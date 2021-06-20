/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.composite;

/**
 *
 * @author Hung
 */
// this is the BankManager class i.e. Composite.  
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
public class BankManager implements Employee {  
     private int id;  
     private String name;  
     private double salary;  
  
     public BankManager(int id,String name,double salary) {  
      this.id=id;      
      this.name = name;  
      this.salary = salary;  
     }  
         List<Employee> employees = new ArrayList<Employee>();  
     @Override  
     public void add(Employee employee) {  
        employees.add(employee);  
     }  
        @Override  
     public Employee getChild(int i) {  
      return employees.get(i);  
     }  
     @Override  
     public void remove(Employee employee) {  
      employees.remove(employee);  
     }    
     @Override  
     public int getId()  {  
      return id;  
     }  
     @Override  
     public String getName() {  
      return name;  
     }  
    @Override  
     public double getSalary() {  
      return salary;  
     }  
     @Override  
     public void print() {  
      System.out.println("==========================");  
      System.out.println("Id ="+getId());  
      System.out.println("Name ="+getName());  
      System.out.println("Salary ="+getSalary());  
      System.out.println("==========================");  
        
      Iterator<Employee> it = employees.iterator();  
        // Xử lý các loại đối tượng khác nhau như một loại đối tượng
          while(it.hasNext())  {  
            Employee employee = it.next();  
            employee.print();  
         }  
     }  
}// End of the BankManager class.  