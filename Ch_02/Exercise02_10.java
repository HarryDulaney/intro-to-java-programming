package Ch_02;

import java.util.Scanner;

//Heats what from an initial temperature to a final temperature

public class Exercise02_10 {
	public static void main(String[]args) {
		
		double initialTemperature;
		double finalTemperature;
		double weightofwater;
		
		
		System.out.println("Enter the weight of the water in Kilograms");
		
		Scanner input = new Scanner(System.in);
		weightofwater = input.nextDouble();
	
		System.out.println("Enter the initial temperature of the water in Celsius");
		
		Scanner input1 = new Scanner(System.in);
		initialTemperature = input1.nextDouble();
		
		System.out.println("Enter the final temperature of the water in Celsius");
		
		Scanner input2 = new Scanner(System.in);
		finalTemperature = input2.nextDouble();
		
		double result;
		
		result = weightofwater * (finalTemperature - initialTemperature) * 4184;
		
		System.out.println("The energy needed is " + result + " Joules");
		
		
	}

}
