package FileManage;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = null;
        try {
            System.out.print("Enter text: ");
            String text = scan.nextLine();

            writer = new BufferedWriter(new FileWriter("src/FileManage/output.txt"));
            writer.write(text);

            System.out.println("Text written to output.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file" + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing file" + e.getMessage());
            }
            scan.close();
        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter text: ");
//        String text = scanner.nextLine();
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\src\\FileManage\\output.txt"))) {
//            writer.write(text);
//            System.out.println("text written to output.txt");
//        } catch (IOException e) {
//            System.out.println("Error in writing file: " + e.getMessage());
//        }
    }
}
