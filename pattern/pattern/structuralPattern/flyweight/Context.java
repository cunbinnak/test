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
 * Extrinsic State
 */
public class Context {
 
    private String id;
    private int star;
 
    public Context(String id, int star) {
        this.id = id;
        this.star = star;
    }
 
    public String getId() {
        return this.id;
    }
 
    public int getStar() {
        return this.star;
    }
}
