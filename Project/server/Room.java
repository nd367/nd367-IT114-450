package Project.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import Project.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;
    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    private static Logger logger = Logger.getLogger(Room.class.getName());

    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }
    //nd367, 7/16/23, format styles 
    String formatStyle(String message) {
        String formatresult = message;
        //bold
        if(formatresult.contains("*")) {
            formatresult = formatresult.replaceAll("\\*(.*?)\\*", "<b>$1</b>");
        }
        //underline
        if(formatresult.contains("_")) {
            formatresult = formatresult.replaceAll("_(.*?)_", "<u>$1</u>");
        }
        //italic
        if(formatresult.contains("-")) {
            formatresult = formatresult.replaceAll("-([^-]+)", "<i>$1</i>");
        }
        //red color
       
        formatresult = formatresult.replaceAll("#r(.*?)#r", "<font color='red'>$1</font>");

        //blue color
        formatresult = formatresult.replaceAll("#b(.*?)#b", "<font color='blue'>$1</font>");

        //green
        formatresult = formatresult.replaceAll("#g(.*?)#g", "<font color='green'>$1</font>");

        
    return formatresult;
        
    }


	//nd367, 7/15/23, Flipping & Rolling
        //Flipping
        public void flipping(ServerThread client) {
            String result = (Math.random() < 0.5) ? "Heads" : "Tails";
            String message = client.getClientName() + " flipped: " + result;
            sendMessage(message);
        }

        //rolling
        public void rolling(ServerThread client, String message) {
            // first format /roll 0-X or 1-X
            String[] cParts = message.split(" ");
            if (cParts.length == 2) {
                try {
                    int maxNum = Integer.parseInt(cParts[1]);
                    int randomNum = (int) (Math.random() * maxNum) + 1;
                    String result = client.getClientName() + " rolled: " + randomNum;
                    sendMessage(result);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                String errorMSG = "Wrong format";
                sendMessage(errorMSG);
            }
        }
        //rolling second format /roll #d#
        public void rolling2(ServerThread client, String message) {
            String[] cParts = message.split(" ");
            if (cParts.length == 2 && cParts[1].contains("d")) {
                try {
                    int rollnum1 = Integer.parseInt(cParts[1].split("d")[0]);
                    int rollnum2 = Integer.parseInt(cParts[1].split("d")[1]);
                    StringBuilder rollResult = new StringBuilder(client.getClientName() + " rolled: ");
                    int total = 0;
                    for (int i = 0; i < rollnum1; i++) {
                        int roll = (int) (Math.random() * rollnum2) + 1;
                        total += roll;
                        rollResult.append(roll).append(" ");
                    }
                    sendMessage(rollResult.toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                String errorMsg = "Wrong format";
                sendMessage(errorMsg);
            }
        }
    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods

    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     */
    protected synchronized void sendMessage(ServerThread sender, String message) {
        if (!isRunning) {
            return;
        }
        logger.info(String.format("Sending message to %s clients", clients.size()));
        //nd367, 7/16/2023, sending formatted message
        boolean isFormatted = false;
        String formatMessage = formatStyle(message);
        if (!formatMessage.equals(message)) {
            isFormatted = true;
        }


        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }

        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            //nd367, 7/16/2023, sending formatted message
            boolean messageSent;
            if (isFormatted) {
                messageSent = client.sendMessage(from, formatMessage);
            } else {
                messageSent = client.sendMessage(from, message);
            }
			//boolean messageSent = client.sendMessage(from, message);
            if (!messageSent) {
                handleDisconnect(iter, client);
            }
        }
    }

    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }
    //nd367, 7/15/2023, sendMessage method for roll and flip
     public void sendMessage(String message) {
        for (ServerThread client : clients) {
            client.sendMessage(client.getClientId(), message);
        }
    }
    

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}