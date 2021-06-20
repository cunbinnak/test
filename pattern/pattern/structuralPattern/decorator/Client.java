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
public class Client {
 
    public static void main(String[] args) {
        System.out.println("NORMAL EMPLOYEE: ");
        EmployeeComponent employee = new EmployeeConcreteComponent("NORMALEMPLOYEE");
        employee.showBasicInformation();
        employee.doTask(); 
        System.out.println("\n TeamMember: ");
        // Làm công việc của normal employee và công việc của TeamMember
        TeamMember member = new TeamMember(employee);
        member.showBasicInformation();
        member.doTask();
        System.out.println("\n TEAMMEMBER & TEAM LEADER: ");
        // Làm công việc của TeamMember và công việc của TeamLeader
        EmployeeComponent leaderAndMember = new TeamLeader(member);
        leaderAndMember.showBasicInformation();
        leaderAndMember.doTask();
        
        System.out.println("\nTEAM LEADER: ");
         // Làm công việc của normal employee và công việc của TeamLeader
        EmployeeComponent teamLeader = new TeamLeader(employee);
        teamLeader.showBasicInformation();
        teamLeader.doTask();
 
     
        
        System.out.println("\nMANAGER: ");
        EmployeeComponent manager = new Manager(employee);
       manager.showBasicInformation();
        manager.doTask();
 
        System.out.println("\nTEAM LEADER AND MANAGER: ");
        EmployeeComponent teamLeaderAndManager = new Manager(teamLeader);
        teamLeaderAndManager.showBasicInformation();
        teamLeaderAndManager.doTask();
        
        System.out.println("\n  MANAGER AND MEMBER ");
        EmployeeComponent managerAndMember = new TeamMember(manager);
        managerAndMember.showBasicInformation();
        managerAndMember.doTask();
    }
}