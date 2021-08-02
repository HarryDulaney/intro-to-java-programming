package ch_03;

import java.util.Scanner;

/**
 * 3.10 (Game: addition quiz) Listing 3.3, SubtractionQuiz.java, randomly
 * generates a subtraction question.
 * <p>
 * Revise the program to randomly generate an addition question with two
 * integers less than 100.
 *
 */
public class Exercise03_10 {

    public static void main(String[] args) {
        int n1 = (int) (Math.random() * 100); // Generate a random double from 0 to 1 * 100 then cast to integer
        int n2 = (int) (Math.random() * 100);

        System.out.print("What is " + n1 + " + " + n2 + "? ");

        Scanner input = new Scanner(System.in);
        int userAnswer = input.nextInt();

        if (n1 + n2 == userAnswer)
            System.out.println("You are correct!");
        else {
            System.out.println("Your answer is wrong.");
            System.out.println(n1 + " + " + n2 + " should be " + (n1 + n2));
            input.close();
        }
    }
}
