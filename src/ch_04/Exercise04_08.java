package ch_04;

import java.util.Scanner;


public class Exercise04_08 {
	public static void main(String[] args) {
		
		System.out.println("Please enter the ASCII code: " );
		
		Scanner input = new Scanner(System.in);
		
		int userInput = input.nextInt();
		
		char output = (char)userInput;
		
		System.out.println("The ASCII character for " + userInput + " is " + output);
		
		
		
	}

}
