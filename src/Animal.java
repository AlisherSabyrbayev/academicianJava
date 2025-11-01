interface Movable {
    void move();
}

interface Flyable {
    void fly();
}

public abstract class Animal {
    private String name;
    private String food;

    public Animal(String name) {
        this.name = name;
    }

    public String sound() {
        return "Roar";
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return this.food;
    }

    public String toString() {
        return name.concat(" says ").concat(sound().concat(" and eats ").concat(food));
    }

}

class Dog extends Animal implements Movable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "Woof";
    }

    public void move() {
        System.out.println("Dog is moving");
    }
}

class Cat extends Animal implements Movable {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "Meow";
    }
    public void move() {
        System.out.println("Cat is moving");
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "Moo";
    }

    public void move() {
        System.out.println("Cow is moving");
    }
}

class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name);
    }


    @Override
    public String sound() {
        return "Chik-Chirik";
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}