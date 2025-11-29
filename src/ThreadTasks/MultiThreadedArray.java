package ThreadTasks;

class EvenSumThread extends Thread {
    private final int[] array;
    private int sum = 0;

    public EvenSumThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int num : array) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        System.out.println("Sum even: " + sum);
    }

    public int getSum() {
        return sum;
    }
}

class OddSumThread extends Thread {
    private final int[] array;
    private int sum = 0;

    public OddSumThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int num : array) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        System.out.println("Sum odd: " + sum);
    }

    public int getSum() {
        return sum;
    }
}

public class MultiThreadedArray {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        EvenSumThread evenCalc = new EvenSumThread(array);
        OddSumThread oddCalc = new OddSumThread(array);
        evenCalc.start();
        oddCalc.start();
    }
}
