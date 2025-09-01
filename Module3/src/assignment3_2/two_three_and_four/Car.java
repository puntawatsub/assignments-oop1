package assignment3_2.two_three_and_four;

public class Car extends AbstractVehicle {


    public Car(String info, int efficiency) {
        super(info, efficiency);
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
    public void charge() {
        System.out.println("Charging is not possible.");
    }
}
