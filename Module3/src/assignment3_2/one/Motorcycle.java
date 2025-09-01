package assignment3_2.one;

public class Motorcycle implements Vehicle {
    private String info;

    public Motorcycle(String info) {
        this.info = info;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return this.info;
    }
}
