package ThreadTasks;

class Scheduler extends Thread {
    private final Runnable task;
    private final String name;
    private final int executionCount;

    public Scheduler(Runnable task, String name, int executionCount) {
        this.task = task;
        this.name = name;
        this.executionCount = executionCount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= executionCount; i++) {
            System.out.println(name + " - execution #" + i);
            task.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Error writing file: " + e.getMessage());
            }
        }
    }
}

public class SchedulerThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task 1 completed");
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task 2 completed");
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task 3 completed");
            }
        };

        Scheduler scheduler1 = new Scheduler(task1, "Eat", 3);
        Scheduler scheduler2 = new Scheduler(task2, "Study", 3);
        Scheduler scheduler3 = new Scheduler(task3, "Pray", 3);

        scheduler1.start();
        scheduler2.start();
        scheduler3.start();
    }
}
