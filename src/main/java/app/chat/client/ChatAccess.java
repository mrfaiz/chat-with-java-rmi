/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.client;

import java.util.Observable;

/**
 *
 * @author Faiz Ahmed
 */
public class ChatAccess extends Observable {

    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }

    public void close() {
        try {
            System.out.println("");
        } catch (Exception ex) {
            notifyObservers(ex);
        }
    }
}
