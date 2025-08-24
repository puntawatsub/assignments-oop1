package assignment2_1.four;

public class CarDriver {
    public static void main(String[] args) {
        CruiseControlCar myCar;
        CruiseControlCar mySecondCar;

        myCar = new CruiseControlCar("Toyota Corolla");
        myCar.fillTank();

        mySecondCar = new CruiseControlCar("Toyota Yaris");

//        for (int i = 0; i < 6; i++) {
//            myCar.accelerate();
//            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
//        }
//
//        while (myCar.getSpeed() > 0) {
//            myCar.decelerate(15);
//            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
//        }

        // cruiseControlTest
        String[] cruiseControlResult = myCar.toggleCruiseControl(140);
        if (Boolean.parseBoolean(cruiseControlResult[0])) {
            System.out.printf("Success, current car speed: %d km/h\n", myCar.getSpeed());
        } else {
            System.out.printf("Cruise control error: %s\n", cruiseControlResult[1]);
        }

        cruiseControlResult = myCar.toggleCruiseControl(180);
        if (Boolean.parseBoolean(cruiseControlResult[0])) {
            System.out.printf("Success, current car speed: %d km/h\n", myCar.getSpeed());
        } else {
            System.out.printf("Cruise control error: %s\n", cruiseControlResult[1]);
        }

        cruiseControlResult = myCar.toggleCruiseControl(20);
        if (Boolean.parseBoolean(cruiseControlResult[0])) {
            System.out.printf("Success, current car speed: %d km/h\n", myCar.getSpeed());
        } else {
            System.out.printf("Cruise control error: %s\n", cruiseControlResult[1]);
        }

        cruiseControlResult = mySecondCar.toggleCruiseControl(140);
        if (Boolean.parseBoolean(cruiseControlResult[0])) {
            System.out.printf("Success, current car speed: %d km/h\n", mySecondCar.getSpeed());
        } else {
            System.out.printf("Cruise control error: %s\n", cruiseControlResult[1]);
        }


    }
}
