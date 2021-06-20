/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.memetoPattern;

/**
 *
 * @author Hung
 */
public class Demo {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
    //1. Save
        System.out.println("1. Save, change and undo   ");
        Originator originator = new Originator(5, 10);  
        careTaker.saveMemento(originator.save(), "SAVE #1");
         System.out.println("State saved #1: " + originator);
   //2. Change 
        originator.setY(originator.getX() *10);
        System.out.println("State changed: " + originator);
   //3. Undo
        originator.undo(careTaker.getMemento("SAVE #1"));
        System.out.println("State after undo: " + originator);  
    }

}
