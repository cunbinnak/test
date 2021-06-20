/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPatternEx2;

/**
 *
 * @author Hung
 */
public class LoggerWorkflow {
    public static Logger getLogger() {
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger fileLogger = consoleLogger.setNext(new FileLogger(LogLevel.ERROR));
        fileLogger.setNext(new EmailLogger(LogLevel.FATAL));
        return consoleLogger;
    }
}
