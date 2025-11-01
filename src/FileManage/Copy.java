package FileManage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("img/source.jpg");
            out = new FileOutputStream("img/copy.jpg");

            byte[] buffer = new byte[4096]; // 1024
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Copy complete");
        } catch (IOException e) {
            System.out.println("Error while copy: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println("Error while closing streams: " + e.getMessage());
            }
        }
//        String sourceFile = "C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\img\\source.jpg";
//        String copyFile = "C:\\Users\\Alisher\\IdeaProjects\\my_poly_proj\\img\\copy.jpg";
//
//        try (FileInputStream in = new FileInputStream(sourceFile);
//             FileOutputStream out = new FileOutputStream(copyFile)) {
//
//            byte[] buffer = new byte[4096]; //byte[1024]
//            int bytesRead;
//
//            while ((bytesRead = in.read(buffer)) != -1) {
//                out.write(buffer, 0, bytesRead);
//            }
//
//            System.out.println("Copied " + sourceFile + " to " + copyFile);
//        } catch (IOException e) {
//            System.out.println("Erorr in copying: " + e.getMessage());
//        }
    }
}
