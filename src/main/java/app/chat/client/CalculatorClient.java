/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.client;

import app.chat.interfaces.ICalculator;

/**
 *
 * @author Faiz Ahmed
 */
public class CalculatorClient {

    public static void main(String[] args) {
        try {
            String host = args.length >= 1 ? args[0] : "localhost";
            String uri = "rmi://" + host + "/calculator";
            java.rmi.registry.Registry reg = java.rmi.registry.LocateRegistry.getRegistry(1099);
            ICalculator cal = (ICalculator) reg.lookup(uri);

            System.out.println("1+1 =>" + cal.add(1, 1));
            System.out.println("Total Operaiton=>" + cal.getTotalOperations());

            cal.getSerializableData().getStuID();
            System.out.println("Total Operaiton=>" + cal.getSerializableData().getNbmerOfRequest());
        } catch (java.rmi.RemoteException | java.rmi.NotBoundException e) {
        }

    }
}
