package HashMap;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class PhoneBookHashMap {
    private static boolean isNameValid(String name) {
        if (!name.matches("^[a-zA-Z' -]+$")) {
            System.out.println("Invalid name!");
            return false;
        }
        return true;
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (!phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}")) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            HashMap<String, String> phoneBook = new HashMap<>();

            while (true) {
                System.out.println("""
                        Press 1 to add an entry in the phonebook,
                        2 to view all the entries
                        3 to search for entries with name
                        4 to delete an entry
                        5 to sort the entries by name
                        6 to write the entries onto a file
                        Any other key to exit""");

                String userAction = sc.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter a name: ");
                    String name = sc.nextLine();

                    if (!isNameValid(name)) {
                        System.out.println("Invalid name!");
                        continue;
                    }

                    if (phoneBook.containsKey(name)) {
                        System.out.println("This is name already exist! Do you want to replace the number? y/n");
                        String repChoice = sc.nextLine();
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    System.out.println("Enter the phone number");
                    String phoneNumber = sc.nextLine();

                    if (!isPhoneNumberValid(phoneNumber)) {
                        continue;
                    }

                    phoneBook.put(name, phoneNumber);
                    System.out.println("The name and number have been added to the phonebook");
                } else if (userAction.equals("2")) {
                    for (String name : phoneBook.keySet()) {
                        System.out.println(name + ": " + phoneBook.get(name));
                    }
                } else if (userAction.equals("3")) {
                    System.out.println("Enter the name you want to search");
                    String keyName = sc.nextLine();

                    if (phoneBook.containsKey(keyName)) {
                        System.out.println("The phone number you are looking for is: " + phoneBook.get(keyName));
                    } else {
                        System.out.println("No such name found in the phonebook");
                    }
                } else if (userAction.equals("4")) {
                    System.out.println("Enter the phone number you want to delete ");
                    String keyName = sc.nextLine();
                    if (phoneBook.containsKey(keyName)) {
                        phoneBook.remove(keyName);
                        System.out.println("The entry has been removed");
                    } else {
                        System.out.println("No such name found in the phonebook");
                    }
                } else if (userAction.equals("5")) {
                    TreeMap phoneBookTreeMap = new TreeMap<String, String>(phoneBook);
                    for (Object keyName : phoneBookTreeMap.keySet()) {
                        System.out.println(keyName + ": " + phoneBookTreeMap.get((String) keyName));
                    }
                }
                else if (userAction.equals("6")) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter("src/HashMap/phonebook.txt"))) {
                        for  (String name : phoneBook.keySet()) {
                            writer.println(name + ": " + phoneBook.get(name));
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to a file: " + e.getMessage());
                    }
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
