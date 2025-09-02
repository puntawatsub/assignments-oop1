// java
import java.util.Random;

public class Calculator {
    private int currentValue = 0;

    // Resets the calculator to zero
    public void reset() {
        currentValue = 0;
    }

    // Adds an integer to the calculator, throws exception for negative numbers
    public void add(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
        currentValue += number;
    }

    // Returns the current value of the calculator
    public int getCurrentValue() {
        return currentValue;
    }

    // Custom exception class for negative numbers
    public static class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }

    // Temporary main method for demonstration
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Random random = new Random();
        try {
            for (int i = 0; i < 5; i++) {
                int number = random.nextInt(20); // random number between 0 and 19
                calculator.add(number);
                System.out.println("Added: " + number + ", Current Value: " + calculator.getCurrentValue());
            }
            calculator.reset();
            System.out.println("After reset: " + calculator.getCurrentValue());
        } catch (NegativeNumberException e) {
            System.err.println(e.getMessage());
        }
    }
}