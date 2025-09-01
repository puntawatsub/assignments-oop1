package assignment3_2.two_three_and_four;

public interface ElectricVehicle {
    public default void charge() {
        System.out.println("Vehicle is charging...");
    }
}
