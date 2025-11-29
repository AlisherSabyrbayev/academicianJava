package ParkingSystem;

public class Vehicle {
    private final String type;
    private final String registration;
    private final String color;

    public Vehicle(String type, String registration, String color) {
        this.type = type;
        this.registration = registration;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getRegistration() {
        return registration;
    }

    public String getColor() {
        return color;
    }
}
