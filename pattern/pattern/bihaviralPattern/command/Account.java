/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.command;

public class Account {
    private String name;
 
    public Account(String name) {
        this.name = name;
    }
 
    public void open() {
        System.out.println("Account [" + name + "] Opened\n");
    }
 
    public void close() {
        System.out.println("Account [" + name + "] Closed\n");
    }
}