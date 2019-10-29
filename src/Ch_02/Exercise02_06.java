package Ch_02;
/*2.6 (Sum the digits in an integer) 
 * Write a program that reads an integer between 0 and 
 * 1000 and adds all the digits in the integer. 
 * For example, if an integer is 932, the sum of all its digits is 14.
 */

import java.util.Scanner;

public class Exercise02_06 {
	public static void main(String[] args) {
		
		int originalNumber;
		
		Scanner input =  new Scanner(System.in);
		
		System.out.print("Enter an integer between 0 and 1000 now: ");
		
		originalNumber = input.nextInt();
		
		System.out.println("The sum of all digits in " + originalNumber + " is " + sumdigits(originalNumber) );
		
	}
	public static int sumdigits(int number) {
		int sum = 0;
		
		for(int i = 1; i < 4 ; i++) {
			
			sum += number % 10;
			
			number = number / 10;
			
		}
		
		
		return sum;
	}

}
