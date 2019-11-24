/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.client;

import app.chat.interfaces.IChatClient;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Faiz Ahmed
 */
public class ChatclientImplementSwing extends java.rmi.server.UnicastRemoteObject implements IChatClient {

    String name;
    ChatAccess chatAccess;

    public ChatclientImplementSwing(String name, ChatAccess chatAccess) throws java.rmi.RemoteException {
        super();
        this.name = name;
        this.chatAccess = chatAccess;
    }

    @Override
    public void send(String msg) throws RemoteException {
        this.chatAccess.notifyObservers(msg);
    }

    @Override
    public void sendExistingUserist(List<String> userLIst) throws RemoteException {
        if (userLIst.size() > 0) {
            this.chatAccess.notifyObservers("===========Existing Users===========");
            userLIst.forEach((s) -> {
                this.chatAccess.notifyObservers(s);
            });
        } else {
            this.chatAccess.notifyObservers("Existing Users: 0");
        }
    }

    @Override
    public String userName() throws java.rmi.RemoteException {
        return this.name;
    }
}
