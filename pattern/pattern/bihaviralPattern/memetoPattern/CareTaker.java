/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.memetoPattern;

import java.util.HashMap;
import java.util.Map;

public class CareTaker { // Gữi chỗ 
    private final Map<String, Memento> savepointStorage = new HashMap<>();
     public void saveMemento(Memento memento, String savedPointName) {
        System.out.println("Saving state..." + savedPointName);
        savepointStorage.put(savedPointName, memento);
    } 
    public Memento getMemento(String savedPointName) {
        System.out.println("Undo at ..." + savedPointName);
        return savepointStorage.get(savedPointName);
    } 
    public void clearSavepoints() {
        System.out.println("Clearing all save points...");
        savepointStorage.clear();
    }
}