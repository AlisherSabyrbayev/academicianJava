import java.util.Scanner;

public class Computer {
    private final String name;
    private final int year;
    private boolean isGaming;

    Computer(String name, int year, boolean isGaming) {
        this.name = name;
        this.year = year;
        this.isGaming = isGaming;
    }

    void turnOn() {
        System.out.println("Computer " + name + " turned on");
    }

    void turnOff() {
        System.out.println("Computer " + name + " turned off");
    }

    public String getName() {
        return name;
    }
}

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }


    public double area() {
        return length * width;
    }
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

public static class Student {
    private String name;
    private int year;
    private String gender;
    private String specialty;

    public Student(String name, int year, String gender, String specialty) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.specialty = specialty;
    }

    void Greetings() {
        System.out.println("Hello, my name is: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}

public static class Car {
    private String name;
    private int year;
    private String color;

    public Car(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    void move() {
        System.out.println("Car is moving");
    }
}

public static class Bank {
    private String bankName;
    private int bankYear;
    private String bankType;
    private String bankCountry;
    private boolean isGovernment;

    public Bank(String bankName, int bankYear, String bankType, String bankCountry, boolean isGovernment) {
        this.bankName = bankName;
        this.bankYear = bankYear;
        this.bankType = bankType;
        this.bankCountry = bankCountry;
        this.isGovernment = isGovernment;
    }
    void display() {
        System.out.println("Bank: " + bankName + ", Founded year: " + bankYear + " ,Type: " + bankType + " ,Location: " + bankCountry);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankYear() {
        return bankYear;
    }

    public void setBankYear(int bankYear) {
        this.bankYear = bankYear;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public boolean isGovernment() {
        return isGovernment;
    }

    public void setGovernment(boolean government) {
        isGovernment = government;
    }
}

public static class Book {
    private String title;
    private String author;
    private float price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public float getPrice() {
        return this.price;
    }
}

public static class Smartphone {
    private String brand;
    private String model;
    private String color;

    public Smartphone(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void turnOn() {
        System.out.println("Smartphone is turned on");
    }

    void turnOff() {
        System.out.println("Smartphone is turned off");
    }
}

public static class Figure {
    private String type;
    private double radius;
    private double width;
    private double height;

    public Figure(double width, double height) {
        this.type = "Rectangle";
        this.width = width;
        this.height = height;
    }

    public Figure(double radius) {
        this.type = "Circle";
        this.radius = radius;
    }

    public double getArea() {
        if (type.equals("Rectangle")) {
            return width * height;
        } else if (type.equals("Circle")) {
            return Math.PI * radius * radius;
        }
        return 0;
    }

    public double getPerimeter() {
        if (type.equals("Rectangle")) {
            return 2 * (width + height);
        } else if (type.equals("Circle")) {
            return 2 * Math.PI * radius;
        }
        return 0;
    }

    public boolean isSquare() {
        if (type.equals("Rectangle")) {
            return width == height;
        }
        return false;
    }

    void draw() {
        if (type.equals("Rectangle")) {
            for (int i = 0; i < (int) height; i++) {
                for (int j = 0; j < (int) width; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        } else if (type.equals("Circle")) {
            System.out.println(" (0) Circle with radius " + radius);
        }
    }
}

public static class Calculator {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        return num1 / num2;
    }
}

public static void main(String[] args) {

    Student Aliya = new Student("Aliya", 2, "Female", "CS");
    Aliya.Greetings();

    Bank Kaspi = new Bank("Kaspi", 2015, "individual", "Kazakhstan", false);
    Kaspi.display();

    Figure Rectangle = new Figure(4, 5);
    Rectangle.draw();

    Calculator calculator = new Calculator();
    double resAdd = calculator.add(1, 2);
    System.out.println(resAdd);

    double resSub = calculator.subtract(8, 2);
    System.out.println(resSub);

    double resMulpiply = calculator.multiply(4, 2);
    System.out.println(resMulpiply);

    double resDivide = calculator.divide(16, 4);
    System.out.println(resDivide);
}



