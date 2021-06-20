/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPatternEx2;

public abstract class Logger {
 
    protected LogLevel logLevel;
 
    protected Logger nextlogger; // The next Handler in the chain
 
    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
 
    // Set the next logger to make a list/chain of Handlers.
    public Logger setNext(Logger nextlogger) {
        this.nextlogger = nextlogger;
        return nextlogger;
    }
//NONE(0), INFO(1), DEBUG(2), WARNING(4), ERROR(8), FATAL(16), ALL(32); 
    public void log(LogLevel severity, String msg) {
        if (logLevel.getLevel() <= severity.getLevel()) {
            writeMessage(msg);
        }
        if (nextlogger != null) {
            nextlogger.log(severity, msg);
        }
    }
 
    protected abstract void writeMessage(String msg);
}