package assignment3_2.two_three_and_four;

public class ElectricCar extends AbstractVehicle implements ElectricVehicle {
    public ElectricCar(String info, int efficiency) {
        super(info, efficiency);
    }

    @Override
    public String calculateFuelEfficiency() {
        return String.format("Efficiency: %d kWh", getEfficiency());
    }
}
