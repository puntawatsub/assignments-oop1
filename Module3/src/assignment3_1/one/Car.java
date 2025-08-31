package assignment3_1.one;


public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    protected int speed;
    protected double gasolineLevel;
    private double gasolineTankCapacity;
    private String typeName;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */

    public Car(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }


    public Car(double gasolineTankCapacity, int speed) {
        gasolineLevel = 0;
        this.speed = speed;
        this.gasolineTankCapacity = gasolineTankCapacity;

        this.typeName = "No Type";
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 5;
        } else {
            speed = 0;
        }
    }
    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    public int getSpeed() {
        return speed;
    }
    public String getTypeName() {
        return typeName;
    }
    public void fillTank() {
        gasolineLevel = 100;
    }
    public double getGasolineLevel() {
        return gasolineLevel;
    }
}

class SportCar extends Car {
    public SportCar(String typeName) {
        super(typeName);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 15;
            gasolineLevel -= 15;
        } else {
            speed = 0;
        }
    }
}
