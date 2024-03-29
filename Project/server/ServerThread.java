package Project.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Project.common.Constants;
import Project.common.Payload;
import Project.common.PayloadType;
import Project.common.RoomResultPayload;

/**
 * A server-side representation of a single client
 */
public class ServerThread extends Thread{

    //nd367, 7/30/23 adding list for mute/unmute
    private List<String> mutedUsers = new ArrayList<>();
 
    //nd367, 7/30/23 checking if user is muted
    public boolean mutedCheck(String username) {
        return mutedUsers.contains(username);
    }
    //nd367, 7/30/23 adding username to list if muted
    public void muteUser(String username, ServerThread muter) {
        if (!mutedUsers.contains(username)) {
            mutedUsers.add(username);
            saveMuted(); //nd367, 8/7/23, calling saveMuted

            //nd367, 8/8/23, sending mute notifictaion 
            currentRoom.muteNote(username, muter.getClientName(), true);
        }
    }
    //nd367, 7/30/23 removing username from list if unmuted
    public void unmuteUser(String username, ServerThread unmuter) {
        mutedUsers.remove(username);
        saveMuted(); //nd367, 8/7/23, calling saveMuted

        //nd367, 8/8/23, sending mute notifictaion 
       currentRoom.muteNote(username, unmuter.getClientName(), false);
    }
    //private String muteListFilePath = "mute_list.csv";
    //nd367, 8/7/23, saving muted users to json file
    private void saveMuted() {
        try (FileWriter writer = new FileWriter("mute_list.csv")) {
            for (String username : mutedUsers) {
                writer.write(username);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMuted() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mute_list.csv"))) {
            String username;
            while ((username = reader.readLine()) != null) {
                mutedUsers.add(username);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket client;
    private String clientName;
    private boolean isRunning = false;
    private ObjectOutputStream out;// exposed here for send()
    // private Server server;// ref to our server so we can call methods on it
    // more easily
    private Room currentRoom;
    private static Logger logger = Logger.getLogger(ServerThread.class.getName());
    private long myClientId;
    public Object getMutedUsers;
    
    public void setClientId(long id) {
        myClientId = id;
    }

    public long getClientId() {
        return myClientId;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public ServerThread(Socket myClient, Room room) {
        logger.info("ServerThread created");
        // get communication channels to single client
        this.client = myClient;
        this.currentRoom = room;

        loadMuted();  //nd367, 8/7/23, loading already muted users

    }

    protected void setClientName(String name) {
        if (name == null || name.isBlank()) {
            logger.warning("Invalid name being set");
            return;
        }
        clientName = name;
    }

    public String getClientName() {
        return clientName;
    }

    protected synchronized Room getCurrentRoom() {
        return currentRoom;
    }

    protected synchronized void setCurrentRoom(Room room) {
        if (room != null) {
            currentRoom = room;
        } else {
            logger.info("Passed in room was null, this shouldn't happen");
        }
    }

    public void disconnect() {
        sendConnectionStatus(myClientId, getClientName(), false);
        logger.info("Thread being disconnected by server");
        isRunning = false;
        cleanup();
    }

    // send methods

    public boolean sendReadyStatus(long clientId) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.READY);
        p.setClientId(clientId);
        return send(p);
    }

    public boolean sendRoomName(String name) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.JOIN_ROOM);
        p.setMessage(name);
        return send(p);
    }

    public boolean sendRoomsList(String[] rooms, String message) {
        RoomResultPayload payload = new RoomResultPayload();
        payload.setRooms(rooms);
        if (message != null) {
            payload.setMessage(message);
        }
        return send(payload);
    }

    public boolean sendExistingClient(long clientId, String clientName) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.SYNC_CLIENT);
        p.setClientId(clientId);
        p.setClientName(clientName);
        return send(p);
    }

    public boolean sendResetUserList() {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.RESET_USER_LIST);
        return send(p);
    }

    public boolean sendClientId(long id) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.CLIENT_ID);
        p.setClientId(id);
        return send(p);
    }

    // nd367 , 7/10/2023
    // The payload type Message is being set to  whenever a client sends a message to the server/other cleints
    // The payload type Connect is used when the client's connection status is connected.
    // The payload type Disconnect is used wheen the client's connection status is disconnected.
    public boolean sendMessage(long clientId, String message) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.MESSAGE);
        p.setClientId(clientId);
        p.setMessage(message);
        return send(p);
    }

    public boolean sendConnectionStatus(long clientId, String who, boolean isConnected) {
        Payload p = new Payload();
        p.setPayloadType(isConnected ? PayloadType.CONNECT : PayloadType.DISCONNECT);
        p.setClientId(clientId);
        p.setClientName(who);
        p.setMessage(String.format("%s the room %s", (isConnected ? "Joined" : "Left"), currentRoom.getName()));
        return send(p);
    }

    private boolean send(Payload payload) {
        try {
            logger.log(Level.FINE, "Outgoing payload: " + payload);
            out.writeObject(payload);
            logger.log(Level.INFO, "Sent payload: " + payload);
            return true;
        } catch (IOException e) {
            logger.info("Error sending message to client (most likely disconnected)");
            // uncomment this to inspect the stack trace
            // e.printStackTrace();
            cleanup();
            return false;
        } catch (NullPointerException ne) {
            logger.info("Message was attempted to be sent before outbound stream was opened: " + payload);
            // uncomment this to inspect the stack trace
            // e.printStackTrace();
            return true;// true since it's likely pending being opened
        }
    }

    // end send methods
    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());) {
            this.out = out;
            isRunning = true;
            Payload fromClient;
            while (isRunning && // flag to let us easily control the loop
                    (fromClient = (Payload) in.readObject()) != null // reads an object from inputStream (null would
                                                                     // likely mean a disconnect)
            ) {

                logger.info("Received from client: " + fromClient);
                processPayload(fromClient);

            } // close while loop
        } catch (Exception e) {
            // happens when client disconnects
            e.printStackTrace();
            logger.info("Client disconnected");
        } finally {
            isRunning = false;
            logger.info("Exited thread loop. Cleaning up connection");
            cleanup();
        }
    }

    void processPayload(Payload p) {
        switch (p.getPayloadType()) {
            case CONNECT:
                setClientName(p.getClientName());
                break;
            case DISCONNECT:
                Room.disconnectClient(this, getCurrentRoom());
                break;
            case MESSAGE:
                if (currentRoom != null) {
                    currentRoom.sendMessage(this, p.getMessage());
                } else {
                    // TODO migrate to lobby
                    logger.log(Level.INFO, "Migrating to lobby on message with null room");
                    Room.joinRoom(Constants.LOBBY, this);
                }
                break;
            //nd367, 7/10/2023
            //Comment: The payload type GET_ROOMS gets data from the server and passes it back to the client. Shows a list of rooms. 
            // The payload type CREATE_ROOM creates a new room with the CREATE_ROOM case in the Room.java file
            //The payload type JOIN_ROOM allows the client to join a new room with the JOIN_ROOM case in the Room.java file
            case GET_ROOMS:
                Room.getRooms(p.getMessage().trim(), this);
                break;
            case CREATE_ROOM:
                Room.createRoom(p.getMessage().trim(), this);
                break;
            case JOIN_ROOM:
                Room.joinRoom(p.getMessage().trim(), this);
                break;
            case READY:
                // ((GameRoom) currentRoom).setReady(myClientId);
                break;
                //nd367, 7/15/23, adding Roll and Flip
            case ROLL:
                getCurrentRoom().rolling(this, p.getMessage());
                //handleRollCommand(p.getMessage());
                break;
            case FLIP:
                getCurrentRoom().flipping(this);
                //handleFlipCommand();
                break;
            default:
                break;

        }

    }
    private void cleanup() {
        logger.info("Thread cleanup() start");
        try {
            client.close();
        } catch (IOException e) {
            logger.info("Client already closed");
        }
        logger.info("Thread cleanup() complete");
    }

    public void sendMessage(String clientName2, String message) {
    }
}