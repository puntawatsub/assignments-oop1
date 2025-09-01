package assignment3_2.one;

import java.util.ArrayList;

public class VehicleDemo {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car car = new Car("Nissan");
        Bus bus = new Bus("Volvo");
        Motorcycle motorcycle = new Motorcycle("I don't know any motorcycle companies LOL");
        vehicles.add(car);
        vehicles.add(bus);
        vehicles.add(motorcycle);

        for (Vehicle vehicle: vehicles) {
            System.out.printf("Vehicle info: %s\n", vehicle.getInfo());
            vehicle.start();
            vehicle.stop();
        }
    }
}
