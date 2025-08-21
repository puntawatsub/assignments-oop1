package assignment1_3.three;

import java.util.Scanner;

public class PrimeNumberGenerator {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for  (int i = 3; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start, end;
        do {
            System.out.print("Enter a positive starting number: ");
            start = Integer.parseInt(sc.nextLine());
        } while (start < 1);
        do {
            System.out.print("Enter a positive ending number: ");
            end = Integer.parseInt(sc.nextLine());
        } while (end <= start);


        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
