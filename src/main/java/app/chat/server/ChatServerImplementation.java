/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server;

import app.chat.interfaces.IChatClient;
import app.chat.interfaces.IChatServer;
import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Faiz Ahmed
 */
public class ChatServerImplementation extends java.rmi.server.UnicastRemoteObject implements IChatServer {

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    private final java.util.Map<String, IChatClient> usersMap = new java.util.concurrent.ConcurrentHashMap<>();

    public ChatServerImplementation() throws RemoteException {
        super();
    }

    @Override
    public synchronized boolean register(IChatClient client, String name) throws RemoteException {
        if (usersMap.containsKey(name)) {
            return false;
        } else {
            usersMap.put(name, client);
            System.out.println(name + " joined ! total clients=>" + usersMap.size());
            executor.execute(new SendUserOnlineStatus(true, name, usersMap));
            executor.execute(new SendUserList(name, usersMap));
        }
        return true;
    }

    @Override
    public synchronized List<String> getUsers() throws RemoteException {
        return new java.util.ArrayList<>(usersMap.keySet());
    }

    @Override
    public synchronized boolean logout(IChatClient c) throws RemoteException {
        usersMap.remove(c.userName());
        executor.execute(new SendUserOnlineStatus(false, c.userName(), usersMap));
        return true;
    }

    @Override
    public synchronized void send(String msg, String sender) throws RemoteException {
        executor.execute(new SendMessageToAll(sender + ": " + msg, sender, usersMap));
        //  System.out.println(msg);
    }
}
