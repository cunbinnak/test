/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.command;

/**
 *
 * @author Hung
 */
public class Demo {
      public static void main(String[] args) {
        Account account = new Account("CommandPattern");
 
        Command open = new OpenAccount(account);
        Command close = new CloseAccount(account);
        BankApp bankApp = new BankApp(open, close);
 
        bankApp.clickOpenAccount();
        bankApp.clickCloseAccount();
    }
}
