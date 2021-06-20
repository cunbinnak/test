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
public class TPBank extends Bank { 
    public TPBank(Account account) {
        super(account);
    }
 
    @Override
    public void openAccount() {
        System.out.print("Open your account at TPBank is a ");
        account.openAccount();
    }
}
