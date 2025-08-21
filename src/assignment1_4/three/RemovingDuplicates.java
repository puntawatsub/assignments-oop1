package assignment1_4.three;

import java.util.Scanner;

public class RemovingDuplicates {

    static boolean isZeroEntered = false;

    static boolean isDuplicate(int[] intArray, int check) {
        if (check == 0 && !isZeroEntered) {
            isZeroEntered = true;
            return false;
        } else if (check == 0) {
            return true;
        }

        for (int value : intArray) {
            if (value == check) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // getting array from user input
        System.out.print("Enter the size of the array: ");
        int arraySize = Integer.parseInt(sc.nextLine());

        int[] numberArray = new int[arraySize];

        System.out.println("Enter the integers into the array: ");

        int arrayIndex = 0;
        for (int i = 0; i < arraySize; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            int enteredNumber = Integer.parseInt(sc.nextLine());

            if (!isDuplicate(numberArray, enteredNumber)) {
                numberArray[arrayIndex] = enteredNumber;
                arrayIndex++;
            }
        }

        // print result
        System.out.println("The array without duplicates: ");
        for (int i = 0; i < arrayIndex; i++) {
            System.out.printf("%d ", numberArray[i]);
        }
        System.out.println();
    }
}
