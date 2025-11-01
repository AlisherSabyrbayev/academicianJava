public class BulbOperate {
    public static void main(String[] args) {
        // Create array of switchable objects to hold different types of bulbs
        Switchable[] switchables = new Switchable[3];

        // create instances of SmartBulb, DimmableBulb, and RegularBulb
        SmartBulb sb = new SmartBulb(); // SmartBulb implements Switchable, Adjustable, and Connectable
        DimmableBulb db = new DimmableBulb(); // DimmableBulb implements Switchable and Adjustable
        RegularBulb rb = new RegularBulb(); // regularBulb implements inly Switchable

        // Populate the array with the bulb instances
        switchables[0] = sb; // Add SmartBulb to the array
        switchables[1] = db; // Add DimmableBulb to the array
        switchables[2] = rb; // Add RegularBulb to the array

        for (int i = 0; i < switchables.length; i++) {
            switchables[i].turnOn();
            switchables[i].turnOff();
        }

        sb.increase();
        
        ((Adjustable) switchables[1]).decrease();

        ((Connectable) switchables[0]).connect();
    }
}
