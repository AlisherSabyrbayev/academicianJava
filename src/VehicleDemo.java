public class VehicleDemo {
    public static void main(String[] args) {
        // car
        Car car = new Car("01", 2017, "Green", true);
        Vehicle vehicle = (Vehicle) new Car("01", 2017, "Green", true);
        car.move();

        System.out.println(car.getColor());
        car.setColor("Blue");
        System.out.println(car.getColor());

        // plane
        Plane plane1 = new Plane("02", 2017, "17890", false);
        plane1.move();
        System.out.println(plane1.getKg());
        plane1.setKg("19893");
        System.out.println(plane1.getKg());

        // boat
        Boat boat2 = new Boat(2017, "03", 888);
        boat2.move();
    }
}
