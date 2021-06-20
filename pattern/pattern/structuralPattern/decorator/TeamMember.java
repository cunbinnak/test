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
public class TeamMember extends EmployeeDecorator {
 
    protected TeamMember(EmployeeComponent employee) {
        super(employee);
    }
  @Override
    public void doTask() {
        employee.doTask();
        reportTask();
        coordinateWithOthers();
    }
    public void reportTask() {
        System.out.println(this.employee.getName() + " is reporting his assigned tasks.");
    }
 
    public void coordinateWithOthers() {
        System.out.println(this.employee.getName() + " is coordinating with other members of his team.");
    }
 
   
}
