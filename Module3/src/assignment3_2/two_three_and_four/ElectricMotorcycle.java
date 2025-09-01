package assignment3_2.two_three_and_four;

public class ElectricMotorcycle extends AbstractVehicle implements ElectricVehicle {
    public ElectricMotorcycle(String info, int efficiency) {
        super(info, efficiency);
    }

    @Override
    public String calculateFuelEfficiency() {
        return String.format("Efficiency: %d kWh", getEfficiency());
    }

}

