package ParkingSystem;

public class Slot {
    private String ticketId;
    private final String vehicleType;
    private Vehicle parkedVehicle;
    private int arrivalHour;

    public Slot(String vehicleType) {
        this.vehicleType = vehicleType;
        this.parkedVehicle = null;
        this.ticketId = null;
        this.arrivalHour = -1;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(int hour) {
        this.arrivalHour = hour;
    }

    public boolean isEmpty() {
        return parkedVehicle == null;
    }

    public void clearSlot() {
        this.parkedVehicle = null;
        this.ticketId = null;
        this.arrivalHour = -1;
    }
}
