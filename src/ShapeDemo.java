import java.util.Scanner;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        Scanner scn = new Scanner(System.in);
        int shapeCount = 0;
        boolean exit = false;

        while(!exit) {
            System.out.println("\n===== Shape Management System =====");
            System.out.println("1. Add a Circle");
            System.out.println("2. Add a Rectangle");
            System.out.println("3. Add a Triangle");
            System.out.println("4. Display all shapes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scn.nextInt();
            scn.nextLine();

            switch(choice) {
                case 1: //add circle
                    if (shapeCount < shapes.length) {
                        System.out.println("Enter circle name: ");
                        String name = scn.nextLine();

                        System.out.println("Enter circle color: ");
                        String color = scn.nextLine();

                        System.out.println("Enter circle radius: ");
                        double radius = scn.nextDouble();
                        scn.nextLine();

                        shapes[shapeCount] = new Circle(name, color, radius);
                        System.out.println("Circle added successfully!");

                        System.out.println("\nCircle Details:");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());

                        shapeCount++;
                    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
                    }
                    break;


                    case 2: // add rectangle
                        if (shapeCount < shapes.length) {
                            System.out.println("Enter rectangle name: ");
                            String name = scn.nextLine();

                            System.out.println("Enter rectangle color: ");
                            String color = scn.nextLine();

                            System.out.println("Enter rectangle lenght: ");
                            double length = scn.nextDouble();

                            System.out.println("Enter rectangle width: ");
                            double width = scn.nextDouble();
                            scn.nextLine();

                            shapes[shapeCount] = new Rectangle(name, color, length, width);
                            System.out.println("Rectangle added successfully!");

                            System.out.println("\nRectangle Details:");
                            System.out.println(shapes[shapeCount].toString());
                            System.out.println("Area: " + shapes[shapeCount].area());
                            System.out.println("Perimeter: " + shapes[shapeCount].perimeter());

                            shapeCount++;
                        } else {
                            System.out.println("Cannot add more shapes. Array is full!");
                        }
                        break;

                        case 3: //add triangle
                            if (shapeCount < shapes.length) {
                                System.out.println("Enter triangle name: ");
                                String name = scn.nextLine();

                                System.out.println("Enter triangle color: ");
                                String color = scn.nextLine();

                                System.out.println("Enter triangle side1: ");
                                double side1 = scn.nextDouble();

                                System.out.println("Enter triangle side2: ");
                                double side2 = scn.nextDouble();

                                System.out.println("Enter triangle side3: ");
                                double side3 = scn.nextDouble();
                                scn.nextLine();

                                shapes[shapeCount] = new Triangle(name, color, side1, side2, side3);
                                System.out.println("Triangle added successfully!");

                                System.out.println("\nTriangle Details:");
                                System.out.println(shapes[shapeCount].toString());
                                System.out.println("Area: " + shapes[shapeCount].area());
                                System.out.println("Perimeter: " + shapes[shapeCount].perimeter());

                                shapeCount++;
                            } else {
                                System.out.println("Cannot add more shapes. Array is full!");
                            }
                            break;

                            case 4: //display all shapes
                                if (shapeCount < 0) {
                                    System.out.println("\n===== All Shapes =====");
                                    for (int i = 0; i < shapeCount; i++) {
                                        System.out.println("\nShape " + (i + 1) + ":");
                                        System.out.println(shapes[i].toString());
                                        System.out.println("Area: " + shapes[i].area());
                                        System.out.println("Perimeter: " + shapes[i].perimeter());
                                        System.out.println("-------------------------");
                                    }
                                } else {
                                    System.out.println("No shapes to display. Please add some shapes first");
                                }
                                break;

                                case 5: // exit
                                    exit = true;
                                    System.out.println("Thank you for using the Shape Management System. Goodbye!");
                                    break;

                                    default:
                                        System.out.println("Invalid choice!");
            }
        }

        scn.close();
    }
}
