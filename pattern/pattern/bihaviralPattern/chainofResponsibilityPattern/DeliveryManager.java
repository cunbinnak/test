/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPattern;

public class DeliveryManager extends Approver {
 
    @Override
    protected boolean canApprove(int numberOfDays) {
        return numberOfDays <= 5;
    }
 
    @Override
    protected void doApproving(LeaveRequest request) {
        System.out.println("Leave request approved for " + request.getDays() + " days by Delivery Manager");
    }
}