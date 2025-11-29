package ThreadTasks;

class NamedThread extends Thread {
    public NamedThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(getName());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadWithName {
    public static void main(String[] args) throws InterruptedException {
        new NamedThread("Жанар").start();
        new NamedThread("Алиш").start();
        new NamedThread("Ислам").start();
    }
}
