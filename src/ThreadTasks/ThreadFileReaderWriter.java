package ThreadTasks;

import java.io.*;

class FileReaderThread extends Thread {
    private final String fileName;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Start reading the file: " + fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNum = 1;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Reading a line: " + lineNum + ": " + line);
                lineNum++;
                Thread.sleep(500);
            }
            System.out.println("Reading file finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

class FileWriterThread extends Thread {
    private final String fileName;

    public FileWriterThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Start writing the file: " + fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            String[] dates = {"Data A", "Data B", "Data C", "Data D", "Data E"};
            for (String date : dates) {
                bufferedWriter.write(date);
                bufferedWriter.newLine();
                System.out.println("Recorded: " + date);
                Thread.sleep(700);
            }
            System.out.println("Writing file finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}

public class ThreadFileReaderWriter {
    public static void main(String[] args) throws IOException, InterruptedException {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputFile))) {
            bufferedWriter.write("Line 1 from the input file\n");
            bufferedWriter.write("Line 2 from the input file\n");
            bufferedWriter.write("Line 3 from the input file\n");
            bufferedWriter.write("Line 4 from the input file\n");
            bufferedWriter.write("Line 5 from the input file\n");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }

        FileReaderThread readerThread = new FileReaderThread(inputFile);
        FileWriterThread writerThread = new FileWriterThread(outputFile);
        readerThread.start();
        writerThread.start();
    }
}
