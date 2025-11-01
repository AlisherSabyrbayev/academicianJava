interface Volume {
    void increaseVol();
    void decreaseVol();
}

interface Switchable {
    void turnOn();
    void turnOff();
}

interface Connectable {
    void connect();
    void disconnect();
}

interface Adjustable {
    void increase();
    void decrease();
}


class SmartSpeaker implements Switchable, Connectable, Volume {
    @Override
    public void turnOn() {
        System.out.println("SmartSpeaker is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartSpeaker is turned off");
    }

    @Override
    public void connect() {
        System.out.println("SmartSpeaker is connected");
    }

    @Override
    public void disconnect() {
        System.out.println("SmartSpeaker is disconnected");
    }

    @Override
    public void increaseVol() {
        System.out.println("SmartSpeaker volume increased");
    }

    @Override
    public void decreaseVol() {
        System.out.println("SmartSpeaker volume decreased");
    }
}

class Fan implements Switchable, Adjustable {
    private int speed = 1;

    @Override
    public void turnOn() {
        System.out.println("Fan is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turned off");
    }

    @Override
    public void increase() {
        speed++;
        System.out.println("Fan speed increased to " + speed);
    }

    @Override
    public void decrease() {
        if (speed > 1) {
            speed--;
            System.out.println("Fan speed decreased to " + speed);
        } else {
            System.out.println("Fan speed is already at minimum speed");
        }
    }
}

public class Bulb {
    public static void main(String[] args) {

        //Demonstrate polymorphism
        Switchable speaker1 = new SmartSpeaker();
        Switchable fan1 = new Fan();

        speaker1.turnOn();
        speaker1.turnOff();
        fan1.turnOn();
        fan1.turnOff();

        //Multiple inheritance through interfaces
        SmartSpeaker smartSpeaker = new SmartSpeaker();
        smartSpeaker.turnOn();
        smartSpeaker.connect();
        smartSpeaker.increaseVol();
        smartSpeaker.decreaseVol();
        smartSpeaker.disconnect();
        smartSpeaker.turnOff();

        //Multiple inheritance through interfaces
        Fan fan = new Fan();
        fan.turnOn();
        fan.increase();
        fan.decrease();
        fan.turnOff();
    }
}

class SmartBulb implements Switchable, Adjustable, Connectable {
    private boolean isOn = false;
    private int brightness = 50;
    private boolean isConnected = false;


    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartBulb is turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartBulb is turned OFF");
    }

    @Override
    public void increase() {
        if (brightness < 100) {
            brightness += 10;
            System.out.println("Brightness increased to " + brightness + "%");
        } else {
            System.out.println("Brightness is already at maximum");
        }
    }

    @Override
    public void decrease() {
        if (brightness > 0) {
            brightness -= 10;
            System.out.println("Brightness decreased to " + brightness + "%");
        } else {
            System.out.println("Brightness is already at minimum");
        }
    }

    // Connectable methods
    @Override
    public void connect() {
        isConnected = true;
        System.out.println("SmartBulb is connected to the network");
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("SmartBulb is disconnected from the network");
    }
}

class DimmableBulb implements Switchable, Adjustable {
    private boolean isOn = false;
    private int brightness = 50; // Default brightness level

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("DimmableBulb is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("DimmableBulb is turned OFF.");
    }

    // Adjustable methods
    @Override
    public void increase() {
        if (brightness < 100) {
            brightness += 10;
            System.out.println("Brightness increased to " + brightness + "%.");
        } else {
            System.out.println("Brightness is already at maximum.");
        }
    }

    @Override
    public void decrease() {
        if (brightness > 0) {
            brightness -= 10;
            System.out.println("Brightness decreased to " + brightness + "%.");
        } else {
            System.out.println("Brightness is already at minimum.");
        }
    }
}

class RegularBulb implements Switchable {
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("RegularBulb is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("RegularBulb is turned OFF.");
    }
}