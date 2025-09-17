package assignment5_2.two;

import java.util.ArrayList;

class ArrayTest {
    private ArrayList<Integer> list;
    public static ArrayTest instance;

    private ArrayTest() {
        list = new ArrayList<>();
    }

    public synchronized void add(Integer e) {
        list.add(e);
    }

    public synchronized void reset() {
        list = new ArrayList<>();
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized void remove(Integer e) {
        list.remove(e);
    }

    public synchronized static ArrayTest getInstance() {
        if (instance == null) {
            instance = new ArrayTest();
        }
        return instance;
    }
}

class TestThread implements Runnable {

    public TestThread() {};

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ArrayTest.getInstance().add(1);
            ArrayTest.getInstance().add(i);
            ArrayTest.getInstance().remove(1);
            Thread.yield();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            TestThread tt = new TestThread();
            TestThread tt1 = new TestThread();
            Thread t = new Thread(tt);
            Thread t1 = new Thread(tt1);

            t.start();
            t1.start();
            try {
                t.join();
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.printf("Array Size: %d\n", ArrayTest.getInstance().size());
            System.out.println(ArrayTest.getInstance().size() == 200);
            ArrayTest.getInstance().reset();
        }

    }
}
