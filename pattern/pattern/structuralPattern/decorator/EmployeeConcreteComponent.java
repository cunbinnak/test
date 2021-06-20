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
import java.util.Date;
// Lập nhân viên bình thường
//
public class EmployeeConcreteComponent implements EmployeeComponent { 
    private String name; 
    public EmployeeConcreteComponent (String name) {
        this.name = name;
    } 
     @Override
    public void doTask() {
        // Unassigned task
    }
    @Override
    public String getName() {
        return name;
    } 
    @Override
    public void join(Date joinDate) {
        System.out.println(this.getName() + " joined on " + formatDate(joinDate));
    }
 
    @Override
    public void terminate(Date terminateDate) {
        System.out.println(this.getName() + " terminated on " + formatDate(terminateDate));     
    }
 
   
}
