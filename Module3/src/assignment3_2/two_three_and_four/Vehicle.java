package assignment3_2.two_three_and_four;

public interface Vehicle {
    public default void start() {
        System.out.println("Vehicle is starting...");
    }
    public default void stop() {
        System.out.println("Vehicle is stopping...");
    }
    public default String getInfo() {
        return "Generic Vehicle";
    }
}
