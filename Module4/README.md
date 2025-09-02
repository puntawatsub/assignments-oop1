**Assignment4_2:** A Calculator class that has the ability to sum positive integers. A negative integer should throw an exception.

```java
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
```

The selected code defines a `Calculator` class in Java, which provides basic arithmetic functionality, specifically for summing positive integers. It also includes a mechanism to handle invalid input (negative numbers) through a custom exception.

The class maintains a private field `currentValue` to store the current sum of integers. This value is initialized to `0` and can be modified using the provided methods. The `reset` method sets `currentValue` back to `0`, effectively clearing the calculator's state:

```java
public void reset() {
    currentValue = 0;
}
```

The `add` method allows adding a positive integer to the calculator. If a negative number is passed, it throws a custom exception, `NegativeNumberException`, to indicate invalid input. This ensures that only positive integers are processed:

```java
public void add(int number) throws NegativeNumberException {
    if (number < 0) {
        throw new NegativeNumberException("Negative numbers are not allowed.");
    }
    currentValue += number;
}
```

The `getCurrentValue` method provides access to the current sum stored in the calculator:

```java
public int getCurrentValue() {
    return currentValue;
}
```

The `NegativeNumberException` is a custom exception class that extends `Exception`. It is used to handle cases where a negative number is added. The exception includes a constructor to accept a custom error message:

```java
public static class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
```

The `main` method demonstrates the functionality of the `Calculator` class. It uses a `Random` object to generate five random integers between `0` and `19`, adds them to the calculator, and prints the current value after each addition. After the loop, the calculator is reset, and the current value is printed again:

```java
for (int i = 0; i < 5; i++) {
    int number = random.nextInt(20);
    calculator.add(number);
    System.out.println("Added: " + number + ", Current Value: " + calculator.getCurrentValue());
}
calculator.reset();
System.out.println("After reset: " + calculator.getCurrentValue());
```

This code effectively demonstrates the use of loops and random number generation to test the `Calculator` class's methods while ensuring that invalid input is handled gracefully.

### Summary:
This code creates a calculator that can add positive numbers together. It keeps track of the total using a variable called `currentValue`. If you try to add a negative number, the calculator will show an error and not add it.

- The `reset` method sets the total back to zero.
- The `add` method adds a number to the total, but only if it’s positive. If it’s negative, it shows an error.
- The `getCurrentValue` method lets you see the current total.
- There’s a special error called `NegativeNumberException` for when someone tries to add a negative number.

In the main part of the code, the calculator picks five random numbers between 0 and 19, adds each one, and shows the total after each step. At the end, it resets the total to zero and shows that too. This helps test that the calculator works and handles errors properly.
