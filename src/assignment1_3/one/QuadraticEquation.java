package assignment1_3.one;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coefficient 1: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient 2: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient 3: ");
        double c = sc.nextDouble();

        double factor1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
        double factor2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);

        if (Double.isNaN(factor1) && Double.isNaN(factor2)) {
            System.out.println("No real roots.");
        } else if (Double.isNaN(factor1)) {
            System.out.printf("One real answer: %f\n", factor2);
        } else if (Double.isNaN(factor2)) {
            System.out.printf("One real answer: %f\n", factor1);
        } else {
            System.out.printf("The two factors are: %f and %f\n", factor1, factor2);
        }

        sc.close();
    }
}
