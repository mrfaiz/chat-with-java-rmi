/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server;

import app.chat.interfaces.IChatClient;
import app.chat.interfaces.IChatServer;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faiz Ahmed
 */
public class ChatServerImplementation extends java.rmi.server.UnicastRemoteObject implements IChatServer {

    private List<String> users = new ArrayList<>();

    public ChatServerImplementation() throws RemoteException {
        super();
    }

    @Override
    public synchronized boolean register(IChatClient client, String name) throws RemoteException {
        if (users.contains(name)) {
            return false;
        } else {
            users.add(name);
        }
        return true;
    }

    @Override
    public synchronized List<String> getUsers() throws RemoteException {
        return users;
    }

    @Override
    public synchronized void logout(IChatClient c) throws RemoteException {

    }

    @Override
    public synchronized void send(String msg) throws RemoteException {
    }
}
