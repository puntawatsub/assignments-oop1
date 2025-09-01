package assignment3_2.two_three_and_four;

import java.util.ArrayList;

public class VehicleDemo {
    public static void main(String[] args) {
        ArrayList<AbstractVehicle> vehicles = new ArrayList<>();

        Car car = new Car("Nissan", 234);
        car.setOld(true);
        Bus bus = new Bus("Volvo", 123);
        Motorcycle motorcycle = new Motorcycle("I don't know any motorcycle companies LOL", 456);
        vehicles.add(car);
        vehicles.add(bus);
        vehicles.add(motorcycle);

        for (AbstractVehicle vehicle: vehicles) {
            System.out.printf("Vehicle info: %s\n", vehicle.getInfo());
            vehicle.start();
            vehicle.stop();
            vehicle.horn();
        }
    }
}
