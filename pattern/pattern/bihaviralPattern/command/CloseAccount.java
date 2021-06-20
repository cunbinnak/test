/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.command;

public class CloseAccount implements Command {
 
    private Account account;
 
    public CloseAccount(Account account) {
        this.account = account;
    }
 
    @Override
    public void execute() {
        account.close();
    }
}
