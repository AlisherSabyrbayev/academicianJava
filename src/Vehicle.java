public abstract class Vehicle { ;
    private int year;
    private String id;

    public Vehicle(int year, String id) {
        this.year = year;
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public String getId() {
        return id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(String id) {
        this.id = id;
    }

    void move() {
        System.out.println("Vehicle is moving");
    }
}
