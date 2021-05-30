package ch_03;

import java.util.Scanner;

/**
 * 3.14 (Game: heads or tails) Write a program that lets the user guess whether
 * the flip of a coin results in heads or tails. The program randomly generates
 * an integer 0 or 1, which represents head or tail. The program prompts the
 * user to enter a guess and reports whether the guess is correct or incorrect.
 */
public class Exercise03_14 {
	public static void main(String[] args) {

		int x = (int) (Math.random() * 2);

		System.out.println("Enter your guess now! 0 for heads, or 1 for tails:");

		Scanner input = new Scanner(System.in);
		int a = input.nextInt();

		if (a == x) {
			System.out.println("You are correct!");
		} else {
			System.out.println("Wrong! Better luck next time!");
			System.out.println("The correct anwser was: " + x);
		}
		input.close();
	}

}
