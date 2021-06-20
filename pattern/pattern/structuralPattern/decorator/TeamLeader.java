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
public class TeamLeader extends EmployeeDecorator {
 
    protected TeamLeader(EmployeeComponent employee) {
        super(employee);
    }
  @Override
    public void doTask() {
        employee.doTask();
        planing();
        motivate();
        monitor();
    }
    public void planing() {
        System.out.println(this.employee.getName() + " is planing.");
    }
 
    public void motivate() {
        System.out.println(this.employee.getName() + " is motivating his members.");
    }
 
    public void monitor() {
        System.out.println(this.employee.getName() + " is monitoring his members.");
    }
 
   
}
