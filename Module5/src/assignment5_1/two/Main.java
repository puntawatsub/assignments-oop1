package assignment5_1.two;

class Result {
    static private Result instance;
    private int result;

    private Result() {
        result = 0;
    }

    public synchronized static Result getInstance() {
        if (instance == null) {
            instance = new Result();
        }
        return instance;
    }

    public synchronized void add(int value) {
        result += value;
    }

    public synchronized int getResult() {
        return result;
    }
}

class Count extends Thread {
    private int start;
    private int end;
    private int[] array;
    private int result = 0;

    /**
     * @param start inclusive
     * @param end exclusive
     * @param array array of numbers to sum
     */
    public Count(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            result += array[i];
            Thread.yield();
        }
        saveResult();
    }

    public void saveResult() {
        Result.getInstance().add(result);
    }
}

public class Main {
    public static void main(String[] args) {

        // generate random number array
        int[] numbers = new int[10000];

        // test result
        int result = 0;

        for (int i = 0; i < 10000; i++) {
            int randomNumber = (int) (Math.random() * 21);
            numbers[i] = randomNumber;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Our system has " + cores + " processor cores\n");

        int numberInEachThreads = (int) numbers.length / cores;

        Count[] counters = new Count[cores];

        for (int i = 0; i < cores; i++) {
            if (i == cores - 1) {
                Count count = new Count(i * numberInEachThreads, numbers.length, numbers);
                count.start();
                counters[i] = count;
            } else {
                Count count = new Count(i * numberInEachThreads, (i + 1) * numberInEachThreads, numbers);
                count.start();
                counters[i] = count;
            }
        }

        for (Count counter: counters) {
            try {
                counter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int number: numbers) {
            result += number;
        }

        System.out.printf("Total sum: %d\n", Result.getInstance().getResult());
        System.out.printf("Total sum normal: %d\n", result);
        System.out.printf("Is sum equal?: %b\n", Result.getInstance().getResult() == result);
    }
}
