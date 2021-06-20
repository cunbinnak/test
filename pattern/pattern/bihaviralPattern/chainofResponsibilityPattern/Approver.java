/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPattern;
// Nguyền phê duyệt
public abstract class Approver {
 
    protected Approver nextApprover;
 
    public void approveLeave(LeaveRequest request) {
        System.out.println("Checking permission for " + this.getClass().getSimpleName());
        if (this.canApprove(request.getDays())) {
            this.doApproving(request);
        } else if (nextApprover != null) {
            nextApprover.approveLeave(request);
        }
    }
 
    public void setNext(Approver approver) {
        this.nextApprover = approver;
    }
 
    protected abstract boolean canApprove(int numberOfDays);
 
    protected abstract void doApproving(LeaveRequest request);
}
