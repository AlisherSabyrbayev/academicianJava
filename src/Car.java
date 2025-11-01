public class Car extends Vehicle {
    private String color;
    public boolean isSport;
     public int myfield;

    public Car(String id, int year, String color, boolean sport) {
        super(year, id);
        this.color = color;
        this.isSport = sport;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    void move() {
        System.out.println("Car is moving");
    }
}
