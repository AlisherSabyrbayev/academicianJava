package FileManage;

import java.io.*;
import java.util.Scanner;

public class ContactReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the contacts file: ");
        String fileName = sc.nextLine();
        int contactCount = 0;

        try  (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;

            System.out.println("\n========CONTACT LIST======");

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        String phoneNumber = parts[1].trim();

                        System.out.println("Contact: " + name + " | Phone: " + phoneNumber);
                        contactCount++;
                    } else {
                        System.out.println("Warning: Skipping improperly formatted line: " + line);
                    }
                }
            }
            System.out.println("\nTotal contacts read: " + contactCount);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
            System.err.println("check the file name and path and try again");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
