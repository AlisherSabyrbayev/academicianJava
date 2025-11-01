package ToDo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListExample {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            ArrayList<Task> todoList = new ArrayList<Task>();

            while (true) {
                System.out.println("""
                        Press 1 to add a task, \
                        
                        2 to view all the tasks \
                        
                        3 to change status of tasks \
                        
                        4 to delete a task \
                        
                        5 to sort the list based on priority \
                        
                        Any other key to exit""");

                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter the task  ");
                    String taskStr = scanner.nextLine();

                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    priority = priority > 3 ? 1 : priority;

                    todoList.add(new Task(taskStr, priority));
                    System.out.println("The task has been added to the list");

                } else if (userAction.equals("2")) {
                    todoList.forEach(task -> System.out.println(task));
                } else if (userAction.equals("3")) {
                    System.out.println("Enter the index of the status you want to change");
                    int chgIdx = Integer.parseInt(scanner.nextLine());

                    if (chgIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = scanner.nextLine();

                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todoList.get(chgIdx).setStatus(Task.COMPLETED);
                        }
                    }

                    System.out.println("The task has been changed in the list");

                } else if (userAction.equals("4")) {
                    System.out.println("Enter the index of the status you want to delete");

                    int rmvIdx = Integer.parseInt(scanner.nextLine());

                    if (rmvIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        todoList.remove(rmvIdx);
                        System.out.println("The task has been removed from the list");
                    }
                } else if (userAction.equals("5")) {
                    Collections.sort(todoList, new Comparator<Task>() {
                        @Override
                        public int compare(Task t1, Task t2) {
                            return Integer.compare(t2.getPriority(), t1.getPriority());
                        }
                    });
                    System.out.println("Tasks sorted by priority (High to Low): ");
                    todoList.forEach(task -> System.out.println(task));
                }
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number");
        }
    }
}
