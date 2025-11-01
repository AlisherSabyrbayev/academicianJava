public class Plane extends Vehicle {
    private String kg;
    private boolean isMilitary;

    public Plane(String id, int year, String kg, boolean isMilitary) {
        super(year, id);
        this.kg = kg;
        this.isMilitary = false;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    @Override
    void move() {
        System.out.println("Plane is flying");
    }
}
