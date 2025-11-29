package ThreadTasks;

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}

public class ThreadsDifferentPriority {
    public static void main(String[] args) throws InterruptedException {
        PriorityThread high = new PriorityThread("High");
        PriorityThread low = new PriorityThread("Low");

        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        high.start();
        low.start();
    }
}
