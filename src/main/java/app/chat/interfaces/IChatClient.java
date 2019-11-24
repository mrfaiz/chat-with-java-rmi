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
public interface IChatClient extends java.rmi.Remote {

    /**
     * Receives a message from the server and prints it.
     *
     * @param msg
     * @throws java.rmi.RemoteException
     */
    public void send(String msg) throws java.rmi.RemoteException;

    public void sendExistingUserist(java.util.List<String> userLIst) throws java.rmi.RemoteException;

   // public void sendLogoutNotificaiton(String userName) throws java.rmi.RemoteException;
    public String userName() throws java.rmi.RemoteException;
}
