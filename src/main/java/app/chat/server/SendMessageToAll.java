/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server;

import app.chat.interfaces.IChatClient;

/**
 *
 * @author Faiz Ahmed
 */
public class SendMessageToAll implements Runnable {

    String message;
    String sender;
    java.util.Map<String, IChatClient> users;

    public SendMessageToAll(String message, String sender, java.util.Map<String, IChatClient> users) {
        this.message = message;
        this.sender = sender;
        this.users = users;
    }

    @Override
    public void run() {
        try {
            ServerUtility.sendAMessageToallButSource(message, sender, users);
        } catch (java.rmi.RemoteException e) {
        }
    }

}
