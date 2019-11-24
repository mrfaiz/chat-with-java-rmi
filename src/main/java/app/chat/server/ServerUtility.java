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
public class ServerUtility {

    public static void sendAMessageToallButSource(String message, String sourceUser, java.util.Map<String, IChatClient> users) throws java.rmi.RemoteException {
        for (var entry : users.entrySet()) {
            if (!entry.getKey().equals(sourceUser)) {
                entry.getValue().send(message);
            }
        }

    }
}
