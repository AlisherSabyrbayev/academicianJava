package ParkingSystem;

import java.util.Scanner;

public class ParkingManager {
    private static final int NUMBER_OF_FLOORS = 4;
    private static final int SLOTS_PER_FLOOR = 6;

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("PL001", NUMBER_OF_FLOORS, SLOTS_PER_FLOOR, "src/ParkingSystem/parking_logger.txt" );

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PARKING MENU =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. Show Available Slots");
            System.out.println("4. Show Occupied Slots");
            System.out.println("5. View Log History");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter vehicle type (car/bike/truck): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter registration number: ");
                    String reg = scanner.nextLine();
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    parkingLot.parkVehicle(type, reg, color);
                }
                case "2" -> {
                    System.out.print("Enter ticket ID: ");
                    String ticket = scanner.nextLine();
                    parkingLot.unparkVehicle(ticket);
                }
                case "3" -> {
                    System.out.print("Enter vehicle type to view available slots: ");
                    String type = scanner.nextLine();
                    parkingLot.showAvailableSlots(type);
                }
                case "4" -> {
                    System.out.print("Enter vehicle type to view occupied slots: ");
                    String type = scanner.nextLine();
                    parkingLot.showOccupiedSlots(type);
                }
                case "5" -> parkingLot.showLogHistory();
                case "6" -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
