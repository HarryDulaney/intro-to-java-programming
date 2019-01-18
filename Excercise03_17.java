package Ch_3;

//rock, paper, scissors game

import java.util.Scanner;

public class Excercise03_17 {
	public static void main(String[] args) {
		
		System.out.println("Enter one of the following numbers:"
				+ " (0)Rock, (1)Paper, (2)Scissors");
		Scanner input = new Scanner(System.in);
		int userPlay = input.nextInt();
		
		int compPlay = (int)(Math.random()* 3);
		
		
		System.out.println("The computer played: " + compPlay);

		
		if (userPlay == compPlay) {
			System.out.println("It is a draw!");
		}
		
		else if (userPlay == 0 && compPlay == 1 ) {
			System.out.println("Paper covers rock!" + "You Loose!");
			
		}
		else if (userPlay == 0 && compPlay == 2 ) {
			System.out.println("Rock breaks scissors!" + " You Won!");
		}
		else if (userPlay == 1 && compPlay == 0) {
			System.out.println("Paper covers rock! " + "You Won!");
			
		}
		else if (userPlay == 1 && compPlay == 2) {
			System.out.println("Scissors cut paper! " + "You Loose!");
		}
		else if (userPlay == 2 && compPlay == 0) {
			System.out.println("Rock breaks scissors! " + "You Loose!");
		}
		else if (userPlay == 2 && compPlay == 1) {
			System.out.println("Scissors cut paper! " + "You Won!");
		}
				
		
	}

}
