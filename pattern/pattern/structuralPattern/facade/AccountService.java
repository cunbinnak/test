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
public class AccountService {
 
    public void getAccount(String email) {
        System.out.println("Getting the account of " + email);
    }
}
