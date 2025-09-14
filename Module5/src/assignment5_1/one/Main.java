package assignment5_1.one;


class EvenPrint extends Thread {

    private int count;

    public EvenPrint() {
        this.count = 0;
    }

    @Override
    public void run() {
        while (true) {
            do {
                this.count++;
            } while (this.count % 2 != 0);
            if (this.count > 20) {
                break;
            }
            System.out.printf("Even Thread: %d\n", this.count);
            Thread.yield();
        }
    }
}

class OddPrint extends Thread {

    private int count;

    public OddPrint() {
        this.count = 0;
    }

    @Override
    public void run() {
        while (true) {
            do {
                this.count++;
            } while (this.count % 2 == 0);
            if (this.count > 20) {
                break;
            }
            System.out.printf("Odd Thread: %d\n", this.count);
            Thread.yield();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EvenPrint ep = new EvenPrint();
        OddPrint op = new OddPrint();
        ep.start();
        op.start();
    }
}
