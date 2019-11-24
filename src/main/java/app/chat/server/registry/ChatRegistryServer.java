/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server.registry;

import app.chat.server.ChatServerImplementation;

/**
 *
 * @author Faiz Ahmed
 */
public class ChatRegistryServer {

    public static void main(String[] args) {
        String host = args.length > 1 ? args[0] : "localhost";
        String uri = "rmi://" + host + "/ChatServer";
        try {
            java.rmi.registry.Registry reg = java.rmi.registry.LocateRegistry.createRegistry(1099);
            ChatServerImplementation chatServerImplementation = new ChatServerImplementation();
            reg.rebind(uri, chatServerImplementation);
        } catch (java.rmi.RemoteException ex) {
        }
    }
}
