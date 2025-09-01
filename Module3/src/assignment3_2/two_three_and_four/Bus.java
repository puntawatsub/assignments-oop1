package assignment3_2.two_three_and_four;

public class Bus extends AbstractVehicle {

    public Bus(String info, int efficiency) {
        super(info, efficiency);
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
    public void charge() {
        System.out.println("Charging is not possible.");
    }
}
