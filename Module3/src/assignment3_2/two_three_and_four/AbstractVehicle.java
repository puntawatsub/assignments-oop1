package assignment3_2.two_three_and_four;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {

    private boolean old;
    private int efficiency;
    private String info;

    public AbstractVehicle(String info, int efficiency) {
        this.info = info;
        this.efficiency = efficiency;
    }

    public void setOld(boolean old) {
        this.old = old;
    }

    public void horn() {
        if (old) {
            System.out.println("Honk!");
        } else {
            System.out.println("Beep");
        }

    }

    public int getEfficiency() {
        return efficiency;
    }

    @Override
    public String getInfo() {
        return info;
    }

    public String calculateFuelEfficiency() {
        return String.format("Efficiency: %d l/km", getEfficiency());
    }
}
