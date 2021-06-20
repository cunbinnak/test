/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.creationalPattern.objectPool;

/**
 *
 * @author Hung
 */
public class TaxiApp {
 
    public static final int NUM_OF_CLIENT = 8;
 
    public static void main(String[] args) {
        TaxiPool taxiPool = new TaxiPool();
        for (int i = 1; i <= NUM_OF_CLIENT; i++) {
            Runnable client = new Client (taxiPool);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}