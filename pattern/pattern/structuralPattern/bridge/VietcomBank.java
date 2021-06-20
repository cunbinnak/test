/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.bridge;

/**
 *
 * @author Hung
 */
public class  VietcomBank extends Bank {
 
    public VietcomBank(Account account) {
        super(account);
    }
 
    @Override
    public void openAccount() {
        System.out.print("Open your account at VietcomBank is a ");
        account.openAccount();
    }
}
