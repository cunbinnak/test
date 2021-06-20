/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.decorator; 
/**
 *
 * @author Hung
 */
public class Manager extends EmployeeDecorator { 
    protected Manager(EmployeeComponent employee) {
        super(employee);
    }
  @Override
    public void doTask() {
        employee.doTask();
        createRequirement();
        assignTask();
        manageProgress();
    }
    public void createRequirement() {
        System.out.println(this.employee.getName() + " is create requirements.");
    }
 
    public void assignTask() {
        System.out.println(this.employee.getName() + " is assigning tasks.");
    }
 
    public void manageProgress() {
        System.out.println(this.employee.getName() + " is managing the progress.");
    }
 
    
}
