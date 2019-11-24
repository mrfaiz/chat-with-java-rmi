/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.interfaces;

/**
 *
 * @author Faiz Ahmed
 */
public interface IChatServer extends java.rmi.Remote {

    public final String RMI_NAME = "ChatServer";

    /**
     * Registers the given client at the server.
     *
     * @param client
     * @param name
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean register(IChatClient client, String name) throws java.rmi.RemoteException;

    /**
     * Returns the collection of users currently logged in.
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public java.util.List<String> getUsers() throws java.rmi.RemoteException;

    /**
     * Removes the given client from the server.
     *
     * @param c
     * @throws java.rmi.RemoteException
     */
    public boolean logout(IChatClient c) throws java.rmi.RemoteException;

    /**
     * Sends the given message to all connected clients.
     *
     * @param msg
     * @throws java.rmi.RemoteException
     */
    public void send(String msg,String sender) throws java.rmi.RemoteException;
}
