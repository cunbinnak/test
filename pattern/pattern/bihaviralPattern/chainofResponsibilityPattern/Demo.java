/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPattern;

/**
 *
 * @author Hung
 */
public class Demo {
     public static void main(String[] args) {
        LeaveRequestWorkflow.getApprover().approveLeave(new LeaveRequest(2));
        System.out.println("---");
        LeaveRequestWorkflow.getApprover().approveLeave(new LeaveRequest(5));
        System.out.println("---");
        LeaveRequestWorkflow.getApprover().approveLeave(new LeaveRequest(7));
    }
}
