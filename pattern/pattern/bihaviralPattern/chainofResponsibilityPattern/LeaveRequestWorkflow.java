/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPattern;

public class LeaveRequestWorkflow {
 
    public static Approver getApprover() {
        Approver supervisor = new Supervisor();
        Approver manager = new DeliveryManager();
        Approver director = new Director();
 
        supervisor.setNext(manager);
        manager.setNext(director);
        return supervisor;
    }
}