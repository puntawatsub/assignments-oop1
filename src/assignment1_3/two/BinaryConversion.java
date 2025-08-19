package assignment1_3.two;

import java.util.Scanner;

public class BinaryConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary number: ");
        String binaryNumber = sc.nextLine();

        int total = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '1') {
                total += Math.pow(2, binaryNumber.length() - i - 1); // the warning says it would be lossy, but int ^ int is int, so in this case it is fine.
            }
        }

        System.out.printf("Total binary number: %d\n", total);
    }
}
