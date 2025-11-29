package ThreadTasks;

class Resource {
    private final String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class DeadlockThread1 extends Thread {
    private final Resource res1;
    private final Resource res2;

    public DeadlockThread1(Resource res1, Resource res2) {
        this.res1 = res1;
        this.res2 = res2;
    }

    @Override
    public void run() {
        synchronized (res1) {
            System.out.println("Thread 1: locked " + res1.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Thread 1: interrupted " + e.getMessage());
            }
            System.out.println("Thread 1: is waiting " + res2.getName());
            synchronized (res2) {
                System.out.println("Thread 1: locked " + res2.getName());
            }
        }
    }
}

class DeadlockThread2 extends Thread {
    private final Resource res1;
    private final Resource res2;

    public DeadlockThread2(Resource res1, Resource res2) {
        this.res1 = res1;
        this.res2 = res2;
    }

    @Override
    public void run() {
        synchronized (res2) {
            System.out.println("Thread 2: locked " + res2.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Thread 2: interrupted " + e.getMessage());
            }
            System.out.println("Thread 2: is waiting " + res1.getName());
            synchronized (res1) {
                System.out.println("Thread 2: locked " + res1.getName());
            }
        }
    }
}

class FixedDeadlockThread1 extends Thread {
    private final Resource resource1;
    private final Resource resource2;

    public FixedDeadlockThread1(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println("Fixed Thread 1: locked " + resource1.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Fixed Thread 1: interrupted " + e.getMessage());
            }

            synchronized (resource2) {
                System.out.println("Fixed Thread 2: locked " + resource2.getName());
            }
        }
    }
}

class FixedDeadlockThread2 extends Thread {
    private final Resource resource1;
    private final Resource resource2;

    public FixedDeadlockThread2(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println("Fixed Thread2: locked " + resource1.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Fixed Thread2: interrupted " + e.getMessage());
            }
            synchronized (resource2) {
                System.out.println("Fixed Thread2: locked " + resource2.getName());
            }
        }
    }
}

public class DeadlockMain {
    public static void main(String[] args) throws InterruptedException {
        Resource resourceA = new Resource("Resource A");
        Resource resourceB = new Resource("Resource B");

        System.out.println("Creating Deadlock\n");
        DeadlockThread1 dt1 = new DeadlockThread1(resourceA, resourceB);
        DeadlockThread2 dt2 = new DeadlockThread2(resourceA, resourceB);
        dt1.start();
        dt2.start();
        Thread.sleep(300);
        System.out.println("Deadlock is occured, Threads are stuck\n");

        System.out.println("Fixed Deadlock version");
        FixedDeadlockThread1 ft1 = new FixedDeadlockThread1(resourceA, resourceB);
        FixedDeadlockThread2 ft2 = new FixedDeadlockThread2(resourceA, resourceB);
        ft1.start();
        ft2.start();
        ft1.join();
        ft2.join();
        System.out.println("Fixed Threads are successfuly completed");

    }
}
