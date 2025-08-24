package assignment1_1.three;

import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give the first number: ");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.print("Give the second number: ");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.print("Give the third number: ");
        int third = Integer.parseInt(scanner.nextLine());

        // Sum (addition)
        int sum = first + second + third;
        // Product = multiplication
        int product = first * second * third;
        // average = sum/number of values, in this case there are three. Divided by a float to result in float (double)
        double average = sum / 3.0;

        // print out the results
        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);
    }
}
