/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server.registry;

import app.chat.server.CalculatorImplementaion;

/**
 *
 * @author Faiz Ahmed
 */
public class RegistryServer {

    public static void main(String[] args) {
        try {
            String host = args.length >= 1 ? args[0] : "localhost";
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
            CalculatorImplementaion cal = new CalculatorImplementaion();
            String uri = "rmi://" + host + "/calculator";
            registry.rebind(uri, cal);
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
