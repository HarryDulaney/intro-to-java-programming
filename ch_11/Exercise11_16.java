package ch_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * *11.16 (Addition quiz) Rewrite Listing 5.1 RepeatAdditionQuiz.java to alert the user
 * if an answer is entered again. Hint: use an array list to store answers. Here is a
 * sample run:
 * What is 5 + 9? 12
 * Wrong answer. Try again. What is 5 + 9? 34
 * Wrong answer. Try again. What is 5 + 9? 12
 * You already entered 12
 * Wrong answer. Try again. What is 5 + 9? 14
 * You got it!
 */
public class Exercise11_16 {
    public static void main(String[] args) {
        ArrayList<Integer> guesses = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        while (answer != number1 + number2) {

            if (guesses.contains(answer)) {
                System.out.println("You've already entered " + answer);
                System.out.print("Try again. What is " + number1 + " + " + number2 + "? ");
                answer = input.nextInt();

            } else {
                guesses.add(answer);
                System.out.print("Wrong answer. Try again. What is " + number1 + " + " + number2 + "? ");
                answer = input.nextInt();
            }

        }

        input.close();
        System.out.println("You got it!");
    }

}
