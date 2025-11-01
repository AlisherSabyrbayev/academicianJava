public class Boat extends Vehicle {
    public int horsePower;

    public Boat(int year, String id, int horsePower) {
        super(year, id);
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    void move() {
        System.out.println("The Boat is sailing");
    }
}
