package ThreadTasks;

class PingThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Ping");
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PongThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Pong");
                Thread.sleep(450);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TwoParallelThread {
    public static void main(String[] args) throws InterruptedException {
        new PingThread().start();
        new PongThread().start();
    }
}
