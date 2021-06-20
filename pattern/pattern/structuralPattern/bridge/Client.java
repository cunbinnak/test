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
public class Client {
 
    public static void main(String[] args) {
        Bank vietcomBank = new VietcomBank(new CheckingAccount());
        vietcomBank.openAccount();
 
        Bank tpBank = new TPBank(new CheckingAccount());
        tpBank.openAccount();
    }
}
