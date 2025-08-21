package assignment1_4.two;

import java.util.Scanner;

public class SubarraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // getting array from user input
        System.out.print("Enter the size of the array: ");
        int arraySize = Integer.parseInt(sc.nextLine());

        int[] numberArray = new int[arraySize];

        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < arraySize; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            numberArray[i] = Integer.parseInt(sc.nextLine());
        }

        int start = 0; int end = 0; int maximum = Integer.MIN_VALUE; // MIN_VALUE found by asking ChatGPT

        // iterating subarrays
        for (int subArrayCount = 1; subArrayCount <= arraySize; subArrayCount++) {
            // iterating each index inside the array
            for (int index = 0; index < arraySize - subArrayCount + 1; index++) {
                int sum = numberArray[index];

                // calculate sum of subarray
                for (int indexIterate = index + 1; indexIterate <= index + subArrayCount - 1; indexIterate++) {
                    sum += numberArray[indexIterate];
                }

                // check if sum is more than the stored sum
                if ( sum > maximum) {
                    maximum = sum;
                    start = index;
                    end = index + subArrayCount - 1;
                }
            }
        }

        // display result
        System.out.printf("Maximum sum: %d\n", maximum);
        System.out.printf("Integers: %d-%d\n", start + 1, end + 1);
    }
}
