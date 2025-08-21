package assignment1_3.four;

import java.util.Scanner;

public class MultiplicationTableExam {

    static int generateRandomNumber() {
        return (int) (Math.random() * 10) + 1;
    }

    static boolean exam(int num1, int num2) {
        int correctAnswer = num1 * num2;

        Scanner sc = new Scanner(System.in);
        System.out.printf("%d x %d = ", num1, num2);
        int answer = Integer.parseInt(sc.nextLine());

        return answer == correctAnswer;
    }

    public static void main(String[] args) {
        System.out.println("Multiplication Exam");
        int point = 0;
        for (int i = 0; i < 10; i++) {
            boolean isCorrect = exam(generateRandomNumber(), generateRandomNumber());
            if (isCorrect) {
                point++;
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        if (point == 10) {
            System.out.println("Score: 10, Congratulations on mastering the multiplication table!");
            return;
        }

        System.out.printf("Score: %d, Try again!\n", point);
        main(args);
    }
}
