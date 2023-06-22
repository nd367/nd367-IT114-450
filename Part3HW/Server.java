package Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }

   // nd367, 6/21/23, message shuffle code for splitting string, convert command to lowercase, and checking for message after the command statement shuffle
      /*   String[] parts = message.split(" ", 2);
        String command = parts[0].toLowerCase();
        String content;
        if (parts.length > 1) {
            content = parts[1];
        } else {
        content = "";
        }
    //nd367, 6/22/23, broadcasting message for shuffle message
          String broadcastMessage;
        if (command.equals("shuffle") || command.equals("randomize")) {
            String randomizedContent = shuffleString(content);
            broadcastMessage = String.format("User[%d]: %s", id, randomizedContent);
        } else {
            broadcastMessage = String.format("User[%d]: %s", id, message);
        }
     */

            // let's temporarily use the thread id as the client identifier to
            // show in all client's chat. This isn't good practice since it's subject to
             // change as clients connect/disconnect
        //message = String.format("User[%d]: %s", id, message); //this was commented out below for message shuffler feature
              // end temp identifier
        
        // loop over clients and send out the message
        String broadcastMessage = String.format("User[%d]: %s", id, message);
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(broadcastMessage); 
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    return true;
                }
            }
            //nd367, 6/22/23, if shuffle command output message
        } else if (message.equalsIgnoreCase("shuffle")) {
            String theMessage =  message.substring(message.indexOf(" ") + 1);
            String shuffledMessage = shuffleString(theMessage);
            String newMessage = String.format("User[%d]: %s", clientId, shuffledMessage);
            broadcast(newMessage, clientId);
            return true;
            //nd367, 6/22/23, if flip command output message 
        }else if (message.equalsIgnoreCase("flip")) {
            String result = flipCoin();
            String flipOutput = String.format("User[%d]: Flipped a coin and got %s", clientId, result);
            broadcast(flipOutput, clientId);

        }
        return false;
    }
    //nd367, 6/22/2023, shuffle message feature: shuffling the characters and returning the string
    public static String shuffleString(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder shuffledString = new StringBuilder(characters.size());
        for (char c : characters) {
            shuffledString.append(c);
        } 
        return shuffledString.toString();
    }
//nd367, 6/22/23, coin toss feature: tossing coin and landing on heads/tails using randomized boolean
        public static String flipCoin() {
        Random random = new Random();
        boolean isHeads = random.nextBoolean();
        if (isHeads) {
            return "heads";
        } else {
            return "tails";
        }
}


    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
    
}