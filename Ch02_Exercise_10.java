package Ch_2;

import java.util.Scanner;

public class Ch02_Exercise_10 {
	public static void main(String[]args) {
		
		double volume;
		
		System.out.println("Enter the volume of water in kilograms");
		 Scanner input = new Scanner(System.in);
		 
		 volume = input.nextDouble();
		 
		 double initialtemp;
		 double finaltemp;
		 
		 
		System.out.println("Enter the initial temperature");
		
		Scanner input1 = new Scanner(System.in);
		initialtemp = input1.nextDouble();
		
		System.out.println("Enter the final temperature");
		Scanner input2 = new Scanner(System.in);
		
		finaltemp = input2.nextDouble();
		
		double finalOutput;
		
		finalOutput = volume * (finaltemp - initialtemp) * 4184;
		
		System.out.println("The energy needed is " + finalOutput);
		
		
		
		

		
		 
	}

}
