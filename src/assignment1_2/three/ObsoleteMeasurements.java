package assignment1_2.three;

import java.util.Scanner;

public class ObsoleteMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight (g): ");
        int grams = Integer.parseInt(sc.nextLine());

        double luoti = grams / 13.28;

        // calculate naula from luoti
        double naula = (luoti - (luoti % 32)) / 32;
        luoti -= naula * 32;

        // calculate leiviskä from naula
        double leiviskä = (naula - (naula % 20)) / 20;
        naula -= leiviskä * 20;

        System.out.printf("%d grams is %d leiviskä, %d naula, and %.2f luoti.\n", grams, (int) leiviskä, (int) naula, luoti);

    }
}
