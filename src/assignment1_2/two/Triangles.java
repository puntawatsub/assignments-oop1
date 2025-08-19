package assignment1_2.two;

import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) {
        double leg1, leg2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter leg 1 length: ");
        leg1 = sc.nextDouble();
        System.out.print("Enter leg 2 length: ");
        leg2 = sc.nextDouble();

        sc.close();

        double hypotenuse = Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
        System.out.printf("The hypotenuse of the triangle is %f\n",  hypotenuse);
    }
}
