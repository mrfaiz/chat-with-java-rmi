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

    int totalOperations;
    SerializableData sObj = new SerializableData();

    public CalculatorImplementaion() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public synchronized int add(int a, int b) {
        System.out.println(" add called ");
        increment();
        return a + b;
    }

    @Override
    public synchronized int substract(int a, int b) {
        increment();
        return a - b;
    }

    @Override
    public synchronized int multiplicaiton(int a, int b) {
        increment();
        return a * b;
    }

    @Override
    public synchronized float division(int a, int b) {
        increment();
        return a / b;
    }

    private void increment() {
        totalOperations++;
    }

    @Override
    public synchronized int getTotalOperations() {
        return totalOperations;
    }

    @Override
    public synchronized SerializableData getSerializableData() {
        return sObj;
    }
}
