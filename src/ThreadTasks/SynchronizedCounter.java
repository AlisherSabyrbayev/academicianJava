package ThreadTasks;

import java.sql.SQLOutput;

class Counter {
    int value = 0;

    void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public void reset() {
        value = 0;
    }
}

class SyncCounter {
    int value = 0;

    synchronized void increment() {
        value++;
    }
}

class SyncIncrementTask implements Runnable {
    private final SyncCounter counter;

    public SyncIncrementTask(SyncCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class IncrementTask implements Runnable {
    private final Counter counter;

    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}


public class SynchronizedCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new IncrementTask(counter));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Result without sync: " + counter.value);


        ///  /////////////////////////
        SyncCounter counterViaSync = new SyncCounter();

        Thread[] threadsViaSync = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threadsViaSync[i] = new Thread(new SyncIncrementTask(counterViaSync));
            threadsViaSync[i].start();
        }

        for (Thread thread : threadsViaSync) {
            thread.join();
        }

        System.out.println("Result with sync: " + counterViaSync.value);
    }
}

