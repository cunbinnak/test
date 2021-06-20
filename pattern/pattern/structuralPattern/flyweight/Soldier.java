/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.flyweight;

/**
 *
 * @author Hung
 */
/**
 * Concrete Flyweight
 */
public class Soldier implements ISoldier { 
    private final String name; // Intrinsic State 
    public Soldier(String name) {
        this.name = name;
        System.out.println("Soldier is created! - " + name);
    }
 
    @Override
    public void promote(Context context) {
        
        System.out.println(name + " " + context.getId() + " promoted " + context.getStar());
    }
}