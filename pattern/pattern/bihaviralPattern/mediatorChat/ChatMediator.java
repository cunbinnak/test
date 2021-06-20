/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.mediatorChat;

public interface ChatMediator {
 
    void sendMessage(String msg, User user);
 
    void addUser(User user);
}
