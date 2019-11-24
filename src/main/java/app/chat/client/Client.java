/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.client;

import app.chat.interfaces.IChatServer;

/**
 *
 * @author Faiz Ahmed
 */
public class Client {

    public static void main(String[] args) {
        String host = args.length > 1 ? args[0] : "localhost";
        String uri = "rmi://" + host + "/ChatServer";
        String clientName = "Faiz3";
        // Then, somewhere in your code
        try {
            ChatclientImplement chatclientImplement = new ChatclientImplement(clientName);
            java.rmi.registry.Registry reg = java.rmi.registry.LocateRegistry.getRegistry(1099);
            IChatServer iChatServer = (IChatServer) reg.lookup(uri);

            boolean success = iChatServer.register(chatclientImplement, clientName);
            System.out.println(success);
            java.util.Scanner sc = new java.util.Scanner(System.in);

            while (true) {
                System.out.println("Enter a message to send ( or 'signout' to end chat):");
                String message = sc.next();
                if (message.equalsIgnoreCase("signout")) {
                    boolean signout = iChatServer.logout(chatclientImplement);
                    if (signout) {
                        System.exit(0);
                    } else {
                        System.out.println("Signout failed");
                    }
                } else {
                    iChatServer.send(message, clientName);
                }
            }
        } catch (java.rmi.RemoteException | java.rmi.NotBoundException ex) {
        }
    }
}
