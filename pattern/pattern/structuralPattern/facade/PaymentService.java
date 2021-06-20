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
public class PaymentService  {
 
    public void paymentByPaypal() {
        System.out.println("Payment by Paypal");
    }
 
    public void paymentByCreditCard() {
        System.out.println("Payment by Credit Card");
    }
 
    public void paymentByEbankingAccount() {
        System.out.println("Payment by E-banking account");
    }
 
    public void paymentByCash() {
        System.out.println("Payment by cash");
    }
}