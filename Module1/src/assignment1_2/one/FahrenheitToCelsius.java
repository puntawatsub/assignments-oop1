package assignment1_2.one;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fahrenheit temperature: ");
        double fahrenheit = sc.nextDouble();
        sc.close();

        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("Celsius temperature: %.1f\n", celsius);
    }
}
