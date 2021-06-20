/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPatternEx2;
public enum LogLevel {
    NONE(0), INFO(1), DEBUG(2), WARNING(3), ERROR(4), FATAL(5), ALL(6);
 
    private int level;
 
    private LogLevel(int level) {
        this.level = level;
    }
 
    public int getLevel() {
        return level;
    }
}