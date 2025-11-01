package FileManage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Manager {
    public static void main(String[] args) {
        String inputFile = "src/FileManage/input.txt";
        String outputFile = "src/FileManage/output.txt";
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split(" +");
                if (!line.isEmpty()) {
                    wordCount += words.length;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Count words in file: " + wordCount);
            System.out.println("Result written to file: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
