package leavetracker;

public class Main {
    public static void main(String[] args) {

        LeaveTrackingSystem system = new LeaveTrackingSystem();

        system.loadEmployeeData();

        Employee employee1 = new Employee(1, "Alisher Sabyrbayev", "IT", "neilqer@gmail.com");
        Employee employee2 = new Employee(2, "Jasulan Kalybek", "IT", "Jasulan@gmail.com");

        system.saveEmployeeData();

        LeaveRequest request1 = new LeaveRequest(101, employee1, "2025-11-01", "2025-11-05","Vacation");
        system.saveLeaveRequest(request1);

        SickLeaveRequest request2 = new SickLeaveRequest(102, employee2, "2025-11-02", "2025-11-03", "Flu", true);
        system.saveLeaveRequest(request2);

        system.backupAll();

        System.out.println("System ready");
    }
}
