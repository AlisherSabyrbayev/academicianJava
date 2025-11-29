package ThreadTasks;

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Task1: " + i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CreatingThread {
    public static void main(String[] args) throws InterruptedException {
        new MyThread().start();
    }
}
