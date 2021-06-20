/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.interpreterPattern;

public class InterpreterEngineContext { 
    public int add(String input) {
        // Tách xâu
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1 + num2);
    } 
    public int subtract(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1 - num2);
    } 
    private String[] interpret(String input) {
        String str = input.replaceAll("[^0-9]", " ");
        str = str.replaceAll("( )+", " ").trim();
        return str.split(" ");
    }
}