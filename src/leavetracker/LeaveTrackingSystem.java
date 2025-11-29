package leavetracker;

import leavetracker.utils.FileUtils;

import java.io.*;
import java.util.*;

public class LeaveTrackingSystem {

    private final Map<Integer, Employee> employeeDirectory = new HashMap<>();

    private final File dataDir = new File("leavetracker_data");
    private final File employeesDir = new File(dataDir, "employees");
    private final File requestsDir = new File(dataDir, "requests");
    private final File reportsDir = new File(dataDir, "reports");
    private final File backupsDir = new File(dataDir, "backups");

    private final File employeeDataFile = new File(dataDir, "employee.csv");

    public LeaveTrackingSystem() {
        initializeFileStructure();
    }


    public void initializeFileStructure() {
        File[] dirs = {dataDir, employeesDir, requestsDir, reportsDir, backupsDir};

        for (File dir : dirs) {
            if (!dir.exists()) dir.mkdir();
        }
    }

    public void saveEmployeeImage(Employee employee, File imageFile) {
        File dest = new File(employeesDir, employee.getEmployeeId() + ".jpg");

        try {
            FileUtils.copyFile(imageFile, dest);
            System.out.println("Image saved for employee: " + employee.getEmployeeId());
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    public File loadEmployeeImage(int employeeId) {
        File img = new File(employeesDir, employeeId + ".jpg");
        return img.exists() ? img : null;
    }

    /*
    saving employee data in format csv (CSV)
     */

    public void saveEmployeeData() {
        try (FileWriter writer = new FileWriter(employeeDataFile)) {
            writer.write("ID,Name, Department,Email,LeaveBalance\n");

            for (Employee e : employeeDirectory.values()) {
                writer.write(
                        e.getEmployeeId() + "," +
                                e.getName() + "," +
                                e.getDepartment() + "," +
                                e.getEmail() + "," +
                                e.getLeaveBalance() + "\n"
                );
            }
            System.out.println("Employees saved");
        } catch (IOException e) {
            System.err.println("Error saving employee: " + e.getMessage());
        }
    }

    public void loadEmployeeData() {
        if (!employeeDataFile.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(employeeDataFile))) {

            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Employee e = new Employee(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
                e.setLeaveBalance(Integer.parseInt(parts[4]));
                employeeDirectory.put(e.getEmployeeId(), e);
            }
            System.out.println("Employees loaded");
        } catch (Exception e) {
            System.err.println("Error loading employees: " + e.getMessage());
        }
    }

    public void saveLeaveRequest(LeaveRequest req) {
        File file = new File(requestsDir, req.getRequestId() + ".txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            out.println("RequestID:" + req.getRequestId());
            out.println("EmployeeID:" + req.getEmployee().getEmployeeId());
            out.println("StartDate:" + req.getStartDate());
            out.println("EndDate:" + req.getEndDate());
            out.println("Status:" + req.getStatus());
            out.println("Reason:" + req.getReason());

            if (req instanceof SickLeaveRequest slr) {
                out.println("Type:Sick");
                out.println("MedicalCertificate:" + slr.isMedicalCertificateProvided());
            } else {
                out.println("Type:Regular");
            }

            System.out.println("Requests saved: " + req.getRequestId());
        } catch (IOException e) {
            System.err.println("Error saving request: " + e.getMessage());
        }
    }

    public File loadLeaveRequestFile(int requestId) {
        File file = new File(requestsDir, requestId + ".txt");
        return file.exists() ? file : null;
    }

    public boolean deleteLeaveRequest(int requestId) {
        File file = new File(requestsDir, requestId + ".txt");
        return file.exists() && file.delete();
    }

    public List<File> findRequestsByStatus(String status) {
        List<File> result = new ArrayList<>();

        for (File file : requestsDir.listFiles()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("Status:") && line.contains(status)) {
                        result.add(file);
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error finding request: " + e.getMessage());
            }
        }
        return result;
    }

    public void backupAll() {
        for (File file : requestsDir.listFiles()) {
            try {
                FileUtils.copyFile(file, new File(backupsDir, file.getName()));
            } catch (IOException e) {
                System.err.println("Error backuping: " + e.getMessage());
            }
        }
        System.out.println("Backup completed");
    }
}
