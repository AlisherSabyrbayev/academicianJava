package FileManage;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/FileManage/input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error while closing file: " + e.getMessage());
            }
        }
//        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\src\\FileManage\\input.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null); {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading file: " + e.getMessage());
//        }
    }
}
