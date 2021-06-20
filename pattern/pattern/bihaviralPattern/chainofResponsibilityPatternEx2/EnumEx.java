/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPatternEx2;

public class EnumEx {

    public static void main(String[] args) {
        Level level = Level.HIGH; 
        System.out.println(level.getLevelCode());// print 3s
    }
}

enum Level { 
    HIGH(3), //calls constructor with value 3
    MEDIUM(2), //calls constructor with value 2
    LOW(1) //calls constructor with value 1
    ; // semicolon needed when fields / methods follow

    private final int levelCode;

    Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

}
