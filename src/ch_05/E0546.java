package ch_05;

/* 5.46 (Reverse a string) Write a program that prompts 
 * the user to enter a string and displays the string in reverse order.
 */

import java.util.Scanner;

public class E0546 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = input.nextLine();
		
		for(int i = str.length()-1;i >= 0;i--) {
			
		System.out.print(str.charAt(i));
		
		}

	}

}
