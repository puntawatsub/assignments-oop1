package assignment3_1.two;

import assignment3_1.one.Car;

public class Bus extends Car {

    private int passengers;

    public Bus(String typeName) {
        super(typeName);
        this.passengers = 0;
    }

    public int getPassengers() {
        return passengers;
    }

    public void passengerEnter() {
        this.passengers++;
    }

    public void passengerExit() {
        this.passengers--;
    }

    public static void main(String[] args) {

    }
}
