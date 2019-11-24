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
public class SendUserOnlineStatus implements Runnable {

    boolean online;
    String currentUser;
    java.util.Map<String, IChatClient> users;

    public SendUserOnlineStatus(boolean online, String currentUser, java.util.Map<String, IChatClient> users) {
        this.online = online;
        this.currentUser = currentUser;
        this.users = users;
    }

    @Override
    public void run() {
        String message = online ? "online" : "offline";
        message = currentUser + " is now " + message;
        try {
            ServerUtility.sendAMessageToallButSource(message, currentUser, users);
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }

}
