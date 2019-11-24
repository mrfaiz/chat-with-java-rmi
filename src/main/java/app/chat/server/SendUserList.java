/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server;

import app.chat.interfaces.IChatClient;
import java.util.ArrayList;

/**
 *
 * @author Faiz Ahmed
 */
public class SendUserList implements Runnable {

    String currentUser;
    java.util.Map<String, IChatClient> users;

    public SendUserList(String currentUser, java.util.Map<String, IChatClient> users) {
        this.currentUser = currentUser;
        this.users = users;
    }

    @Override
    public void run() {
        IChatClient currentUserCallBack = users.get(currentUser);
        java.util.List<String> usersList = new ArrayList<>();
        users.entrySet().stream().filter((entry) -> (!entry.getKey().equals(currentUser))).forEachOrdered((entry) -> {
            usersList.add(entry.getKey());
        });
        try {
            currentUserCallBack.sendExistingUserist(usersList);
        } catch (java.rmi.RemoteException ex) {
        }
    }

}
