package HashMap;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskManagement {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Task> taskBook = new HashMap<>();

            while (true) {
                System.out.println("""
                        Press 1 to add an entry in the TaskBook,
                        2 to view all the tasks
                        3 to search for tasks with name
                        4 to update the status of the task
                        5 to delete a task
                        6 to sort the tasks by name
                        7 to write the tasks onto a file
                        Any other key to exit""");

                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter a task");
                    String name = scanner.nextLine();
                    if (taskBook.containsKey(name)) {
                        System.out.println("This task already exists. Do you wanna replace it? y/n");

                        String repChoice = scanner.nextLine();
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    System.out.println("Enter the Task description");
                    String description = scanner.nextLine();
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    priority = priority > 3 ? 1 : priority;

                    taskBook.put(name, new Task(name, description, priority));
                    System.out.println("The book has been added to the TaskBook");
                } else if (userAction.equals("2")) {
                    for (String name : taskBook.keySet()) {
                        System.out.println(name + ": " + taskBook.get(name));
                    }
                } else if (userAction.equals("3")) {
                    System.out.println("Enter the taskName you want to search");
                    String keyName = scanner.nextLine();

                    if (taskBook.containsKey(keyName)) {
                        System.out.println(taskBook.get(keyName));
                    } else {
                        System.out.println("No such task found in the taskBook");
                    }
                } else if (userAction.equals("4")) {
                    System.out.println("Enter the nameof the task you want to update ");
                    String keyName = scanner.nextLine();

                    if (taskBook.containsKey(keyName)) {
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = scanner.nextLine();

                        if (updatedStatus.equalsIgnoreCase("P")) {
                            taskBook.get(keyName).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            taskBook.get(keyName).setStatus(Task.COMPLETED);
                        }
                        System.out.println("The task has been updated");
                    } else {
                        System.out.println("No such task found in the taskBook");
                    }
                } else if (userAction.equals("5")) {
                    System.out.println("The the name you want to delete ");
                    String keyName = scanner.nextLine();

                    if (taskBook.containsKey(keyName)) {
                        taskBook.remove(keyName);
                        System.out.println("The task has been removed");
                    } else {
                        System.out.println("No such task found in the taskBook");
                    }
                } else if (userAction.equals("6")) {
                    TreeMap taskBookTreeMap = new TreeMap<String, Task>(taskBook);

                    for (Object keyName : taskBookTreeMap.keySet()) {
                        System.out.println(keyName + ": " + taskBookTreeMap.get((String) keyName));
                    }
                } else if (userAction.equals("7")) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter("src/HashMap/taskBook.txt"))) {
                        for (String name : taskBook.keySet()) {
                            writer.println(name + ": " + taskBook.get(name) + "\n\n");
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                } else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number");
        }
    }
}
