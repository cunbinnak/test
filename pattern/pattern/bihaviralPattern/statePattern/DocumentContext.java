/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.statePattern;
public class DocumentContext { 
    private State state; 
    public void setState(State state) {
        this.state = state;
    } 
    public void applyState() {
        this.state.handleRequest();
    }
}