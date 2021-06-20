/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.statePattern;
public class StatePatternExample { 
    public static void main(String[] args) {
        DocumentContext context = new DocumentContext(); 
        context.setState(new NewState());
        context.applyState();
 
        context.setState(new SubmittedState());
        context.applyState();
 
        context.setState(new ApprovedState());
        context.applyState();
    }
}

