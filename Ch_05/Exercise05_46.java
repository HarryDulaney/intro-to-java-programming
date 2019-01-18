package Ch_05;

/* 5.46 (Reverse a string) Write a program that prompts 
 * the user to enter a string and displays the string in reverse order.
 */
import java.util.Scanner;

public class Exercise05_46 {
	public static void main(String[] args) {
		
		System.out.println("Enter a string: ");
		
		Scanner input = new Scanner(System.in);
		
		String toBeflipped = input.nextLine();
		String afterFlipped = "";
		int x = toBeflipped.length()-1;
		
		while(x >= 0) {
			 
			afterFlipped += toBeflipped.charAt(x);
			x--;
		}
		
	
		System.out.println(afterFlipped);
		
	
		
		
	}

}
