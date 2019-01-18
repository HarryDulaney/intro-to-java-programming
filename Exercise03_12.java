package Ch_3;

import java.util.Scanner;

//Palindrome number program

public class Exercise03_12 {
	public static void main(String[] args) {
		
		System.out.println("Please enter a three digit integer:");
		
		Scanner input = new Scanner(System.in);
		int startNum = input.nextInt();
		
		int numLast = startNum % 10;
		int numMiddle = (startNum / 10) % 10;
		int numFirst = startNum/ 100;
		
		if ( numLast == numFirst) {
			System.out.println("This number is a Palindrome!");
		}
		else 
			System.out.println("This number is not a Palindrome :(" );
				
		
	}

}
