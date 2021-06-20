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
import java.util.Random;
import java.util.concurrent.TimeUnit;
 
public class Client  implements Runnable {
     
    private TaxiPool taxiPool;
     
    public Client (TaxiPool taxiPool) {
        this.taxiPool = taxiPool;
    }
 
    @Override
    public void run() {
        takeATaxi();
    }
 
    private void takeATaxi() {
        try {
            System.out.println("New client: " + Thread.currentThread().getName());
            Taxi taxi = taxiPool.getTaxi();
             
            TimeUnit.MILLISECONDS.sleep(randInt(1000, 1500)); 
             
            taxiPool.release(taxi);
            System.out.println("Served the client: " + Thread.currentThread().getName());
        } catch (InterruptedException | TaxiNotFoundException e) {
            System.out.println(">>>Rejected the client: " + Thread.currentThread().getName());
        }
    }
     
    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}