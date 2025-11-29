package ParkingSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final String lotId;
    private final List<List<Slot>> floors;
    private final ParkingLogger logger;

    public ParkingLot(String lotId, int numberOfFloors, int slotsPerFloor, String logFilePath) {
        this.lotId = lotId;
        this.logger = new ParkingLogger(logFilePath);
        this.floors = new ArrayList<>();

        for (int f = 0; f < numberOfFloors; f++) {
            List<Slot> floorSlots = new ArrayList<>();
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("bike"));
            for (int i = 3; i < slotsPerFloor; i++) {
                floorSlots.add(new Slot("car"));
            }
            floors.add(floorSlots);
        }
    }

    public String parkVehicle(String type, String registration, String color) {
        Vehicle vehicle = new Vehicle(type, registration, color);

        for (int floorIndex = 0; floorIndex < floors.size(); floorIndex++) {
            List<Slot> floorSlots = floors.get(floorIndex);
            for (int slotIdx = 0; slotIdx < floorSlots.size(); slotIdx++) {
                Slot slot = floorSlots.get(slotIdx);
                if (slot.getVehicleType().equals(type) && slot.isEmpty()) {
                    slot.setParkedVehicle(vehicle);
                    String ticket = generateTicket(floorIndex + 1, slotIdx + 1);
                    slot.setTicketId(ticket);

                    int arrivalHour = 10;
                    slot.setArrivalHour(arrivalHour);

                    logger.logParking(ticket, type, registration, color, arrivalHour);
                    System.out.println("Vehicle parked. Ticket ID: " + ticket);
                    return ticket;
                }
            }
        }

        System.out.println("No available slot for type: " + type);
        return null;
    }

    public void unparkVehicle(String ticket) {
        if (ticket == null || ticket.isBlank()) {
            System.out.println("Invalid ticket.");
            return;
        }

        String[] parts = ticket.split("_");
        if (parts.length != 3) {
            System.out.println("Ticket format incorrect.");
            return;
        }

        int floorNum, slotNum;
        try {
            floorNum = Integer.parseInt(parts[1]);
            slotNum = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Ticket numbers invalid.");
            return;
        }

        if (floorNum < 1 || floorNum > floors.size()) {
            System.out.println("Floor number out of range.");
            return;
        }

        List<Slot> floorSlots = floors.get(floorNum - 1);
        if (slotNum < 1 || slotNum > floorSlots.size()) {
            System.out.println("Slot number out of range.");
            return;
        }

        Slot slot = floorSlots.get(slotNum - 1);
        if (slot.isEmpty()) {
            System.out.println("Slot already empty or wrong ticket.");
            return;
        }

        int arrival = slot.getArrivalHour();
        int exit = arrival + 3;
        int stayHours = exit - arrival;
        int rate = getRate(slot.getVehicleType());
        int charge = stayHours * rate;
        String reg = slot.getParkedVehicle().getRegistration();

        System.out.println("Vehicle " + reg + " unparked.");
        System.out.println("Arrived at: " + arrival + ":00, left at: " + exit + ":00");
        System.out.println("Amount due: " + charge + " KZT");

        logger.logUnparking(slot.getTicketId(), slot.getVehicleType(), reg, arrival, exit, stayHours, charge);
        slot.clearSlot();
    }

    private int getRate(String vehicleType) {
        return switch (vehicleType) {
            case "bike" -> 200;
            case "car" -> 500;
            case "truck" -> 2000;
            default -> 0;
        };
    }

    private String generateTicket(int floor, int slotNumber) {
        return lotId + "_" + floor + "_" + slotNumber;
    }

    public void showAvailableSlots(String type) {
        System.out.println("Available slots for type: " + type);
        for (int floorIndex = 0; floorIndex < floors.size(); floorIndex++) {
            List<Slot> floorSlots = floors.get(floorIndex);
            for (int slotIdx = 0; slotIdx < floorSlots.size(); slotIdx++) {
                Slot slot = floorSlots.get(slotIdx);
                if (slot.isEmpty() && slot.getVehicleType().equals(type)) {
                    System.out.println("Floor " + (floorIndex + 1) + " Slot " + (slotIdx + 1));
                }
            }
        }
    }

    public void showOccupiedSlots(String type) {
        System.out.println("Occupied slots for type: " + type);
        for (int floorIndex = 0; floorIndex < floors.size(); floorIndex++) {
            List<Slot> floorSlots = floors.get(floorIndex);
            for (int slotIdx = 0; slotIdx < floorSlots.size(); slotIdx++) {
                Slot slot = floorSlots.get(slotIdx);
                if (!slot.isEmpty() && slot.getVehicleType().equals(type)) {
                    System.out.println("Floor " + (floorIndex + 1) + " Slot " + (slotIdx + 1)
                            + " (" + slot.getParkedVehicle().getRegistration() + ")");
                }
            }
        }
    }

    public void showLogHistory() {
        logger.displayLog();
    }
}
