/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.mediatorChat;

/**
 *
 * @author Hung
 */
public class Demo {
     public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl("Java design pattern");
         
        User admin = new UserImpl(mediator, "Admin");
        User user1 = new UserImpl(mediator, "User 1");
        User user2 = new UserImpl(mediator, "User 2");
        User user3 = new UserImpl(mediator, "User 3");
         
        mediator.addUser(admin);
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
 
        admin.send("Hi All"); // admin gửi đến tất cả
        user1.send("Hi Admin"); // user1 gửi đến tấp cả
    }
}
