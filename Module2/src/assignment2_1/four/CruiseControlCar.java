package assignment2_1.four;

import assignment2_1.two.Car;

public class CruiseControlCar extends Car {

    private boolean cruiseControlOn;
    private int targetSpeed;
    private int[] cruiseLimit = {20, 140};

    public CruiseControlCar(String typeName) {
        super(typeName);
    }

    // toggleCruiseControl
    public String[] toggleCruiseControl(int targetSpeed) {
        if (targetSpeed < cruiseLimit[0]) {
            return new String[]{"false", "Cruise speed too low"};
        } else if (targetSpeed > cruiseLimit[1]) {
            return new String[]{"false", "Cruise speed too high"};
        } else if (targetSpeed % 10 != 0) {
            return new String[]{"false", "Cruise speed invalid, must be a multiple of 10"};
        }

        this.targetSpeed = targetSpeed;

        while (true) {
            // check conditions
            if (this.getSpeed() == targetSpeed) {
                break;
            }
            if (this.getGasolineLevel() <= 0 && this.getSpeed() < targetSpeed) {
                return new String[]{"false", "Not enough fuel"};
            }

            // accelerate or decelerate
            if (this.getSpeed() > targetSpeed) {
                decelerate(this.getSpeed() - targetSpeed);
            } else {
                accelerate();
            }
        }
        return new String[]{"true", ""};
    }

}



