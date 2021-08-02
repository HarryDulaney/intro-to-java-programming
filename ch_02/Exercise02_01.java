package ch_02;

import java.util.Scanner;

/** 2.1
 * Reads Celsius in double value from the console and converts it to Fahrenheit
 */
public class Exercise02_01 {
	public static void main(String[]args) {
		double Celsius; 
		double Fahrenheit;
		
		System.out.println("Enter degrees in Celsius");
		Scanner input = new Scanner(System.in);
		Celsius = input.nextDouble();
		
		Fahrenheit = (9.0/5.0 * Celsius + 32);

		System.out.println(Fahrenheit);
		
		input.close();
	}
}
