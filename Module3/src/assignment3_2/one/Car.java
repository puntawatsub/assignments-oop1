package assignment3_2.one;

public class Car implements Vehicle {

    private String info;

    public Car(String info) {
        this.info = info;
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return this.info;
    }

}
