package ch_07;

/* 7.14 (Computing gcd) Write a method that returns 
 * the gcd of an unspecified number of integers.
 * The method header is specified as follows:
 * Then write a test program that has the user input 5 numbers and displays the
 * gcd by calling the method.
 */
import java.util.Scanner;

public class Exercise07_14 {
	public static int gcd(int... numbers) {
		
		int gcd = 1;
		int minNum = numbers[0];
		
		for(int i = 1; i < numbers.length; i++) {
			
			if (numbers[i] < minNum) {
				
				minNum = numbers[i];
		}
	
		}
		int count = 0;
		for (int i = 2; i <= minNum; i++) {
		
			for (int x = 0; x < numbers.length; x++) {
				
				if(numbers[x] % i == 0) {
					
					count++;
	
				if(count == numbers.length)
				gcd = i;	
				}
					
				else {
					count = 0;
				}
					
					
			}
			

		}
		
		return gcd;
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner inputer = new Scanner(System.in);
		System.out.println("Enter five integers: ");
		
		int[] numbers = new int [5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = inputer.nextInt();
		}
		
		System.out.println(gcd(numbers));
		
		
	}

}
