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
public class Demo {
      public static void main(String[] args) {
        // Build the chain of responsibility -- Workflow
        //ConsoleLogger -->FileLogger-->EmailLogger
        Logger logger = LoggerWorkflow.getLogger(); 
        
          // Handled by ConsoleLogger
        logger.log(LogLevel.DEBUG, "Debug message");
 
        // Handled by ConsoleLogger and FileLogger
        logger.log(LogLevel.ERROR, "Error message");
 
        // Handled by ConsoleLogger, FileLogger, EmailLogger
        logger.log(LogLevel.FATAL, "Factal message");
    }
}
