/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.mediatorChat;

import java.util.ArrayList;
import java.util.List;
 
public class ChatMediatorImpl implements ChatMediator { 
    public ChatMediatorImpl(String groupName) {
        System.out.println(groupName + " group already created");
    } 
    // Danh sách users trong nhóm
    private List<User> users = new ArrayList<>();
 
    @Override
    public void addUser(User user) {
        System.out.println(user.name + " joined this group");
        this.users.add(user);
    }
 
    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (!u.equals(user)) {
                u.receive(msg);
            }
        }
    }
}
