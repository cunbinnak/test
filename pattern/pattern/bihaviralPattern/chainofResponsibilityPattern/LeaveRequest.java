/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.chainofResponsibilityPattern;
// Để lại yêu cầu
public class LeaveRequest {
    private int days;
 
    public LeaveRequest(int days) {
        this.days = days;
    }
 
    public int getDays() {
        return days;
    }
}