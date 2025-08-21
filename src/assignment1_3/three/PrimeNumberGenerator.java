package assignment1_3.three;

public class PrimeNumberGenerator {
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for  (int i = 3; i * i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {

    }
}
