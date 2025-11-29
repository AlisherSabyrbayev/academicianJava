package ThreadTasks;

import java.util.Random;

class MaxFinder extends Thread {
    private final int[] array;
    private final int start;
    private final int end;
    private int max = Integer.MIN_VALUE;

    public MaxFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Thread [" + start + "-" + (end - 1) + "] find max: " + max);
    }

    public int getMax() {
        return max;
    }
}

public class MultiThreadedMaxSearch {
    public static void main(String[] args) throws InterruptedException {
        int[] bigArray = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            bigArray[i] = rand.nextInt(1000);
        }

        MaxFinder[] finders = new MaxFinder[5];
        int partSize = 20;
        for (int i = 0; i < 5; i++) {
            finders[i] = new MaxFinder(bigArray, i * partSize, (i + 1) * partSize);
            finders[i].start();
        }

        int globalMax = Integer.MIN_VALUE;
        for (MaxFinder finder : finders) {
            finder.join();
            if (finder.getMax() > globalMax) {
                globalMax = finder.getMax();
            }
        }
        System.out.println("General Max: " + globalMax);
    }
}
