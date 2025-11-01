package FileManage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encryption {
    private static final int KEY = 5;

    public static int getKey() {
        return KEY;
    }

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;


        try {
            in = new FileInputStream("src/FileManage/notEncrypted.txt"); // notEncrypted.txt
            out = new FileOutputStream("src/FileManage/encrypted.txt"); // encrypted.txt

            int b;
            while ((b = in.read()) != -1) {
                out.write(b ^ getKey());
            }

            System.out.println("File encrypted/decrypted complete");
        } catch (IOException e) {
            System.out.println("Error while encrypted/decrypted processes: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println("Error while closing: " + e.getMessage());
            }
        }
//        String input = "C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\src\\FileManage\\notEncrypted.txt"; // notEncrypted.txt
//        String output = "C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\src\\FileManage\\encrypted.txt"; // encrypted.txt
//
//        try (FileInputStream in = new FileInputStream(input);
//             FileOutputStream out = new FileOutputStream(output)) {
//
//            int b;
//            while ((b = in.read()) != -1) {
//                out.write(b ^ 5);
//            }
//
//            System.out.println("File encrypted/decrypted: " + output);
//        } catch (IOException e) {
//            System.out.println("Error while encryp/decrypt file: " + e);
//        }
    }
}
