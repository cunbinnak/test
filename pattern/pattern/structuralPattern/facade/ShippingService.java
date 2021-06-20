/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.facade;

/**
 *
 * @author Hung
 */
public class ShippingService {
 
    public void freeShipping() {
        System.out.println("Free Shipping");
    }
 
    public void standardShipping() {
        System.out.println("Standard Shipping");
    }
 
    public void expressShipping() {
        System.out.println("Express Shipping");
    }
}
