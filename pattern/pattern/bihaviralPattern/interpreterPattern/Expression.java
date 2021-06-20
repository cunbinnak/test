/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.interpreterPattern;

interface Expression { 
    int interpret(InterpreterEngineContext context);
} 
class AddExpression implements Expression { 
    private String expression; 
    public AddExpression(String expression) {
        this.expression = expression;
    } 
    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.add(expression);
    }
} 
class SubtractExpression implements Expression { 
    private String expression; 
    public SubtractExpression(String expression) {
        this.expression = expression;
    } 
    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.subtract(expression);
    }
}
