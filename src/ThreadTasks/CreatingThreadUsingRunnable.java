package ThreadTasks;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        char[] letters = {'A', 'B', 'C', 'D', 'E'};
        try {
            for (char letter : letters) {
                System.out.println("Task2: " + letter);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CreatingThreadUsingRunnable {
    public static void main (String[] args) throws InterruptedException {
        new Thread(new MyRunnable()).start();
    }
}
