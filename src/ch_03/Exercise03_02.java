package ch_03;

import java.util.Scanner;

/**
 * 3.2 (Game: add three numbers) The program in Listing 3.1, AdditionQuiz.java, generates
 * two integers and prompts the user to enter the sum of these two integers.
 * Revise the program to generate three single-digit integers and prompt the user to
 * enter the sum of these three integers.
 *
 */
public class Exercise03_02 {

    public static void main(String[] args) {

        int a = (int) (System.currentTimeMillis() % 10);
        int b = (int) (System.currentTimeMillis() / 7 % 10);
        int c = (int) (System.currentTimeMillis() / 5 % 10);

        int correctAnswer = a + b + c;


        Scanner input = new Scanner(System.in);

        System.out.print("Fill in your answer and then press enter: " + a + " + " + b + " + " + c + " = ");

        int userAnswer = input.nextInt();

        if (userAnswer == correctAnswer) {
            System.out.println("Congrats! That is correct!");
        } else
            System.out.println("That is incorrect, please try again");


    }

}
