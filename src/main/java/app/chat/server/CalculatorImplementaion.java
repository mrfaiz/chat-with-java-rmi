/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.server;

import app.chat.interfaces.ICalculator;

/**
 *
 * @author Faiz Ahmed
 */
public class CalculatorImplementaion extends java.rmi.server.UnicastRemoteObject implements ICalculator {

    public CalculatorImplementaion() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) {
        System.out.println(" add called ");
        return a + b;
    }

    @Override
    public int substract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplicaiton(int a, int b) {
        return a * b;
    }

    @Override
    public float division(int a, int b) {
        return a / b;
    }

}
