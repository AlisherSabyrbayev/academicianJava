interface Swimmable {
    void swim();
}



public class Duck implements Swimmable, Flyable {
    private String name;
    public Duck(String name) {
        this.name = name;
    }

    void Sound() {
        System.out.println("Krya-Krya");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }

    @Override
    public void fly() {
        System.out.println("Duck flying");
    }
}

class Airplane implements Flyable {
    private String name;
    public Airplane(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void fly() {
        System.out.println("Airplane is flying");
    }
}

class Fish implements Swimmable {
    private String name;
    public Fish(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void swim() {
        System.out.println("Fish is swimming");
    }
}
