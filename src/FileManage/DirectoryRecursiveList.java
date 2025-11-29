package FileManage;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class DirectoryRecursiveList {
    static void directoryList(File dirObj) {
        System.out.println("Printing " + dirObj + " recursively");

        File[] files = dirObj.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println(files[i].getAbsolutePath());
            } else {
                directoryList(files[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPress 1 to recursively list a directory," + "\nAny other key to exit");

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                System.out.println("Enter the name of the directory with the path");
                String dirName = scanner.nextLine();

                File dirObj = new File(dirName);

                if (dirObj.exists() && dirObj.isDirectory()) {
                    directoryList(dirObj);
                } else {
                    System.out.println(dirName + " is not a valid directory");
                    continue;
                }
            }
            else {
                System.out.println("Bye");
                break;            }
        }
    }
}
