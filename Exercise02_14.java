package Ch_2;

import java.util.Scanner;

public class Exercise02_14 {
	public static void main(String[]args) {
		
		double weightPounds;
		double heightInches;
		double weightKilograms;
		double heightMeters;
		
		System.out.println("Enter your weight in pounds:");
		
		Scanner input = new Scanner(System.in);
		weightPounds = input.nextDouble();
		
		System.out.println("Enter your height in inches:");
		
		Scanner input1 = new Scanner(System.in);
		heightInches = input1.nextDouble();
		
		weightKilograms = weightPounds * 0.45359237;
		heightMeters = heightInches * 0.0254;
		
		System.out.println("Your BMI is " + weightKilograms/(heightMeters * heightMeters));
		
	
	}

}
