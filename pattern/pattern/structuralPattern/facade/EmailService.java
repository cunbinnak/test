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
public class EmailService {
 
    public void sendMail(String mailTo) {
        System.out.println("Sending an email to " + mailTo);
    }
}
