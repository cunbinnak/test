/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.interpreterPattern;

/**
 *
 * @author Hung
 */
public class Demo {
    public static void main(String args[]) {
        System.out.println("21 cộng 8 = " + interpret("21 cộng 8"));
        System.out.println("10 trừ 3 = " + interpret("10 trừ 3"));
    }
 
    private static int interpret(String input) {
        Expression exp = null;
        if (input.contains("cộng")) {
            exp = new AddExpression(input);
        } else if (input.contains("trừ")) {
            exp = new SubtractExpression(input);
        } else {
            throw new UnsupportedOperationException();
        }
        return exp.interpret(new InterpreterEngineContext());
    }
}
