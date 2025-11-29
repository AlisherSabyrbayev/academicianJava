package ThreadTasks;

import org.w3c.dom.ls.LSOutput;

class CountdownTimer extends Thread {
    private final int seconds;
    private final String name;

    public CountdownTimer(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        for (int i = seconds; i > 0; i--) {
            System.out.println(name + " - Осталось: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " - Время вышло!");
    }
}

public class CountdownTimerMain {
    public static void main(String[] args) throws InterruptedException {
        CountdownTimer timer1 = new CountdownTimer("Timer-1", 5);
        CountdownTimer timer2 = new CountdownTimer("Timer-2", 3);
        timer1.start();
        timer2.start();
    }
}
