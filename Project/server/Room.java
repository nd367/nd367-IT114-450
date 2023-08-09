package Project.server;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import Project.client.User;
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
    private final static String ROLL = "roll";
    private final static String FLIP = "flip";
    private final static String MUTE = "mute";
    private final static String UNMUTE = "unmute";
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

    ///nd367, 8/8/23, adding getClientByUsername for mute notification
    public ServerThread getClientByUsername(String username) {
        for (ServerThread client : clients) {
            if (client.getClientName().equalsIgnoreCase(username)) {
                return client;
            }
        }
        return null;
    }
    
    //nd367, 8/8/23, sending mute notification
    protected synchronized void muteNote(String targetUsername, String muterUsername, boolean notifyMuted) {
        ServerThread target = getClientByUsername(targetUsername);
        if (target != null){
            String notify = notifyMuted ? "muted" : "unmuted";
            String notifyMessage = muterUsername + " " + notify + " you";
            target.sendMessage(Constants.DEFAULT_CLIENT_ID, notifyMessage);
        }
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
            formatresult = formatresult.replaceAll("-([^-]+)-", "<i>$1</i>");
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
            //nd367, 7/25/2023, output in different format (italicize) with html <i> and </i>
            String message = "<i>" + client.getClientName() + " flipped a coin and got " + result + "!" + "</i>"; 
            sendMessage(client, message);
        }

    
        // nd367, 7/27/23 rolling handling first and second format. Fixing so both formats work. The second format was not working properly before
        // first format /roll 0-X or 1-X and second format is /roll #d#
        public void rolling(ServerThread client, String message) {
            String[] cParts = message.split(" ");
            if (cParts.length == 2) {
                try {
                    if (cParts[1].contains("d")) {
                        String[] rollParts = cParts[1].split("d");
                        if (rollParts.length == 2) {
                            int rollnum1 = Integer.parseInt(rollParts[0]);
                            int rollnum2 = Integer.parseInt(rollParts[1]);
                            int total = 0;
                            for (int i = 0; i < rollnum1; i++) {
                                int roll = (int) (Math.random() * rollnum2) + 1;
                                total += roll;
                            }
                            //nd367, 7/25/23, bolding output with html <b> and </b>
                            String result = "<b>" + client.getClientName() + " rolled " + rollnum1 + "d" + rollnum2 + " and got " + total + "!" +"</b>";
                            sendMessage(client, result);
                        } else {
                            String errorMsg = "<b>Wrong format</b>";
                            sendMessage(client, errorMsg);
                        }
                    } else {
                        int maxNum = Integer.parseInt(cParts[1]);
                        int randomNum = (int) (Math.random() * maxNum) + 1;
                        //nd367, 7/25/23, bolding output with html <b> and <b/>
                        String result = "<b>" + client.getClientName() + " rolled " + maxNum + " and got " + randomNum + "!" + "</b>";
                        sendMessage(client, result);
                    }
                } catch (NumberFormatException e) {
                    String errorMsg = "<b>Error</b>";
                    sendMessage(client, errorMsg);
                    e.printStackTrace();
                }
            } else {
                String errorMsg = "<b>Wrong format</b>";
                sendMessage(client, errorMsg);
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
                        //nd367, 7/25/2023, calls the rolling method (both formats). 
                    case ROLL:
                        rolling(client, message);
                        break;
                        //nd367, 7/25/2023, calls the flipping method
                    case FLIP:
                        flipping(client);
                        break;
                    case MUTE: //nd367, 7/29/23, adding Mute and Unmute case 
                        if (comm2.length >= 2) {
                            String muteTarget = comm2[1];
                            client.sendMessage(Constants.DEFAULT_CLIENT_ID, "You muted " + muteTarget);
                            client.muteUser(muteTarget, client);
                        } else {
                            client.sendMessage(Constants.DEFAULT_CLIENT_ID, "Wrong format");
                        }
                        break;
                    case UNMUTE:
                        if (comm2.length >= 2) {
                            String unmuteTarget = comm2[1];
                            if (client.mutedCheck(unmuteTarget)) {
                                client.sendMessage(Constants.DEFAULT_CLIENT_ID, "You unmuted " + unmuteTarget);
                                client.unmuteUser(unmuteTarget, client);
                            } else {
                                client.sendMessage(Constants.DEFAULT_CLIENT_ID, unmuteTarget + " is not muted.");
                            }
                        } else {
                            client.sendMessage(Constants.DEFAULT_CLIENT_ID, "Wrong format");
                        }
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

        //nd367, 8/8/23, highlighting message
       /*if (lastSender) {
        message = "<span style='background-color: yellow'><b>" + message + "</b></span>";
      */

        //nd367, 7/28/23, checking for whisper message
        if (message.startsWith("@")) {
            
            int spaceAfterUsername = message.indexOf(" ");
            String whisperUsername = message.substring(1, spaceAfterUsername);
            String whisperMessage = message.substring(spaceAfterUsername + 1);
 
            ServerThread whisperedUser = null;
            for (ServerThread client : clients) {
                if (client.getClientName().equalsIgnoreCase(whisperUsername)) {
                    whisperedUser = client;
                    break;
                }
            }

            if (whisperedUser != null) {
                whisperedUser.sendMessage(sender.getClientId(), "You received a whispered message: " + whisperMessage);
                sender.sendMessage(sender.getClientId(), "You whispered to "+ whisperedUser.getClientName() + ": " + whisperMessage);
            } else {
                sender.sendMessage(sender.getClientId(), "User not found");
            }
            
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

            //nd367, 8/1/23, does not send message to the muter
            if (client.mutedCheck(sender.getClientName())) {
                continue;
            }
            
            //nd367, 7/16/2023, sending formatted message
            boolean messageSent;
            if (isFormatted) {
                messageSent = client.sendMessage(from, formatMessage);
            } else {
                messageSent = client.sendMessage(from, message);
            }
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
        sendMessage(client, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}