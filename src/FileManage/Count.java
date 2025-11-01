package FileManage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Count {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("src/FileManage/input.txt"));

            int lines = 0, chars = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                lines++;
                chars += line.length();
            }

            System.out.println("Lines: " + lines);
            System.out.println("Chars: " + chars);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error while closing: " + e.getMessage());
            }
        }
//        int lines = 0, chars = 0;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\src\\FileManage\\input.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                lines++;
//                chars += line.length();
//            }
//
//            System.out.println("Lines: " + lines);
//            System.out.println("Chars: " + chars);
//
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
    }
}