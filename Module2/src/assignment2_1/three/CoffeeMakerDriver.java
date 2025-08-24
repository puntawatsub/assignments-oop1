package assignment2_1.three;

import java.util.Arrays;
import java.lang.Error;

class CoffeeMaker {
    private final String[] coffeeType = {"normal", "espresso"};
    private String currentCoffeeType;
    private double coffeeAmount;

    private final int[] coffeeAmountMinMax = {10, 80};

    private boolean on;

    public CoffeeMaker() {
        this.currentCoffeeType = this.coffeeType[0];
        this.coffeeAmount = 45;
        this.on = false;
    }

    public CoffeeMaker(String coffeeType, double coffeeAmount) {
        if (!Arrays.asList(this.coffeeType).contains(coffeeType)) {
            throw new IllegalArgumentException("Coffee type not available");
        }

        if (coffeeAmount > this.coffeeAmountMinMax[1]) {
            this.coffeeAmount = (double) this.coffeeAmountMinMax[1];
        } else if (coffeeAmount < this.coffeeAmountMinMax[0]) {
            this.coffeeAmount = (double) this.coffeeAmountMinMax[0];
        } else {
            this.coffeeAmount = coffeeAmount;
        }

        this.currentCoffeeType = coffeeType;
        this.on = false;
    }

    // setters
    public void pressOnOff() {
        this.on = !this.on;
    }
    public void setCoffeeType(String coffeeType) {
        if (!on) {
            return;
        }
        if (!Arrays.asList(this.coffeeType).contains(coffeeType)) {
            throw new IllegalArgumentException("Coffee type not available");
        }

        this.currentCoffeeType = coffeeType;
    }
    public void setCoffeeAmount(double coffeeAmount) {
        if (!on) {
            return;
        }
        if (coffeeAmount > this.coffeeAmountMinMax[1]) {
            this.coffeeAmount = (double) this.coffeeAmountMinMax[1];
        } else if (coffeeAmount < this.coffeeAmountMinMax[0]) {
            this.coffeeAmount = (double) this.coffeeAmountMinMax[0];
        } else {
            this.coffeeAmount = coffeeAmount;
        }
    }

    // getters
    public boolean isOn() {
        return this.on;
    }
    public String getCurrentCoffeeType() {
        return this.currentCoffeeType;
    }
    public double getCoffeeAmount() {
        return this.coffeeAmount;
    }
}

public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        coffeeMaker.pressOnOff();
        System.out.printf("Coffee maker is %s\n", coffeeMaker.isOn() ? "on" : "off");
        coffeeMaker.setCoffeeType("espresso");
        System.out.printf("Coffee type is %s\n", coffeeMaker.getCurrentCoffeeType());
        coffeeMaker.setCoffeeAmount(50);
        System.out.printf("Coffee amount is %.2f ml\n", coffeeMaker.getCoffeeAmount());
        coffeeMaker.pressOnOff();
        System.out.printf("Coffee maker is %s\n", coffeeMaker.isOn() ? "on" : "off");

    }
}
