package ToDo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    ======================
                    Menu:  \
                    
                    1. Add a student \
                    
                    2. Update a student \
                    
                    3. Delete a student \
                    
                    4. View all students \
                    
                    5. Sort students by age \
                    
                    6. Exit
                    
                    Enter your choice:
                    ======================""");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter student name: ");
                String name = scanner.nextLine();

                System.out.println("Enter student age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter student major: ");
                String major = scanner.nextLine();

                students.add(new Student(name, age, major));
                System.out.println("Student added successfully!");
            }
            else if (choice == 2) {
                System.out.println("Enter the index of the student to update: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 0 && index < students.size()) {
                    System.out.println("Enter new name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter new age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter new major: ");
                    String major = scanner.nextLine();

                    students.get(index).setName(name);
                    students.get(index).setAge(age);
                    students.get(index).setMajor(major);
                    System.out.println("Student updated successfully!");
                } else {
                    System.out.println("Invalid index. No Student found at the specified index");
                }
            }
            else if (choice == 3) {
                System.out.println("Enter the index of the student to delete: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 0 && index < students.size()) {
                    students.remove(index);
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Invalid index. No Student found at the specified index");
                }
            }
            else if (choice == 4) {
                if (students.isEmpty()) {
                    System.out.println("No students found");
                } else {
                    System.out.println("\nList of students: ");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + ". " + students.get(i));
                    }
                }
            }
            else if (choice == 5) {
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Integer.compare(s1.getAge(), s2.getAge());
                    }
                });

                System.out.println("Students sorted by age (ascending): ");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(i + ". " + students.get(i));
                }
            }

            else if (choice == 6) {
                System.out.println("Exiting program...");
                break;
            }

            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

    }
}
