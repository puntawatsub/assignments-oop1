package assignment3_2.one;

public class Bus implements Vehicle {
    private String info;

    public Bus(String info) {
        this.info = info;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return this.info;
    }
}
