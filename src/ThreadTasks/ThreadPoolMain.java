package ThreadTasks;

import java.util.LinkedList;
import java.util.Queue;

class ThreadPool {
    private final Queue<Runnable> tasks = new LinkedList<>();
    private final Worker[] workers;
    private boolean isRunning = true;


    public ThreadPool(int size) {
        workers = new Worker[size];
        for (int i = 0; i < size; i++) {
            workers[i] = new Worker();
            workers[i].start();
        }
    }

    public synchronized void submit(Runnable task) throws InterruptedException {
        tasks.add(task);
        notify();
    }

    public synchronized Runnable take() throws InterruptedException {
        while (tasks.isEmpty() && isRunning) {
            wait();
        }
        return tasks.poll();
    }

    public synchronized void shutdown() throws InterruptedException {
        isRunning = false;
        notifyAll();
    }

    private class Worker extends Thread {
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = take();
                } catch (InterruptedException e) {
                    System.err.println("Error occured: " + e.getMessage());
                }

                if (task == null && !isRunning) {
                    break;
                }

                if (task != null) {
                    task.run();
                }
            }
        }
    }
}

class MyTask implements Runnable {
    private final int id;

    public MyTask(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Completing the task " + id);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println("Error occured: " + e.getMessage());
        }
    }
}

public class ThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            pool.submit(new MyTask(i));
        }

        pool.shutdown();
    }
}
