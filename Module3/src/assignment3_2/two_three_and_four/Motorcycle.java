package assignment3_2.two_three_and_four;

public class Motorcycle extends AbstractVehicle {

    public Motorcycle(String info, int efficiency) {
        super(info, efficiency);
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
    public void charge() {
        System.out.println("Charging is not possible.");
    }
}
