/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.interfaces;

import app.chat.server.SerializableData;
import java.rmi.RemoteException;

/**
 *
 * @author Faiz Ahmed
 */
public interface ICalculator extends java.rmi.Remote {

    int add(int a, int b) throws RemoteException;

    int substract(int a, int b) throws RemoteException;

    int multiplicaiton(int a, int b) throws RemoteException;

    float division(int a, int b) throws RemoteException;

    int getTotalOperations() throws RemoteException;

    SerializableData getSerializableData() throws RemoteException;
}
