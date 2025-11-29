package ParkingSystem;

import java.io.*;

public class ParkingLogger {
    private final File logFile;

    public ParkingLogger(String filePath) {
        this.logFile = new File(filePath);
        if (!logFile.exists()) {
            try {
                File parent = logFile.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }
                logFile.createNewFile();
                System.out.println("Created log file: " + logFile.getPath());
            } catch (IOException e) {
                System.err.println("Error creating log file: " + e.getMessage());
            }
        }
    }

    public void logParking(String ticketId, String vehicleType, String registration, String color, int hour) {
        String record = String.format(
                "PARK | Ticket: %s | Type: %s | Reg: %s | Color: %s | Arrived at: %02d:00%n",
                ticketId, vehicleType, registration, color, hour
        );
        appendRecord(record);
    }

    public void logUnparking(String ticketId, String vehicleType, String registration, int arrivalHour, int exitHour, int hours, int amount) {
        String record = String.format(
                "UNPARK | Ticket: %s | Type: %s | Reg: %s | Arrived: %02d:00 | Left: %02d:00 | Stayed: %d h | Charge: %d KZT%n",
                ticketId, vehicleType, registration, arrivalHour, exitHour, hours, amount
        );
        appendRecord(record);
    }

    public void displayLog() {
        System.out.println("\n--- Parking History ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }
            if (empty) System.out.println("(no records yet)");
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }

    private void appendRecord(String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(record);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
