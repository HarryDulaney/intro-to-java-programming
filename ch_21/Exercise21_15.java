package ch_21;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * *21.15 (Addition quiz) Rewrite Programming Exercise 11.16 to store the answers in a
 * set rather than a list.
 * <p>
 * {@linkplain ch_11.Exercise11_16}
 */
public class Exercise21_15 {
    public static void main(String[] args) {
        Set<Integer> guesses = new HashSet<>();

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