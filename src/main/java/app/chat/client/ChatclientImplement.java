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
public class ChatclientImplement extends java.rmi.server.UnicastRemoteObject implements IChatClient {

    String name;

    public ChatclientImplement(String name) throws java.rmi.RemoteException {
        super();
        this.name = name;
    }

    @Override
    public void send(String msg) throws RemoteException {
        System.out.println(msg);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendExistingUserist(List<String> userLIst) throws RemoteException {
        System.out.println("Existing Users");
        userLIst.forEach((s) -> {
            System.out.println(s);
        }); //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void sendLogoutNotificaiton(String userName) throws RemoteException {
//        System.out.println(userName + " logged out!");
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public String userName() throws java.rmi.RemoteException {
        return this.name;
    }
}
