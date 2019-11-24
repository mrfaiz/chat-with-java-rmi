/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server;

import java.io.Serializable;

/**
 *
 * @author Faiz Ahmed
 */
public class SerializableData implements Serializable {

    int userName;
    int stuID;
    int nubmerOfRequest;

    public synchronized int getUserName() {
        nubmerOfRequest++;
        return userName;
    }

    public synchronized void setUserName(int userName) {
        nubmerOfRequest++;
        this.userName = userName;
    }

    public synchronized int getStuID() {
        nubmerOfRequest++;
        return stuID;
    }

    public synchronized void setStuID(int stuID) {
        nubmerOfRequest++;
        this.stuID = stuID;
    }
    public synchronized int getNbmerOfRequest() {
       return nubmerOfRequest;
    }
}
