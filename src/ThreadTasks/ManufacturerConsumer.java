package ThreadTasks;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public synchronized void manufacture(int value) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            System.out.println("Queue is full, manufacture is waiting...");
            wait();
        }
        queue.add(value);
        System.out.println("Manufactured: " + value + " (size: " + queue.size() + ")");
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty, consumer is waiting...");
            wait();
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value + " (size: " + queue.size() + ")");
        notify();
    }
}

class Manufacturer extends Thread {
    private final SharedQueue queue;

    public Manufacturer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for  (int i = 0; i <= 20; i++) {
                queue.manufacture(i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private final SharedQueue queue;

    public Consumer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 20; i++) {
                queue.consume();
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ManufacturerConsumer {
    public static void main(String[] args) throws InterruptedException {
        SharedQueue Sharedqueue = new SharedQueue();
        Manufacturer manufacturer = new Manufacturer(Sharedqueue);
        Consumer consumer = new Consumer(Sharedqueue);
        manufacturer.start();
        consumer.start();
    }
}


