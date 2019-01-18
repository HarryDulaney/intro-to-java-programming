package Ch_2;

import java.util.Scanner;

public class Exercise02_23 {
	public static void main(String[]args) {
		
		double distance;
		double milesPergallon;
		double pricePergallon;
		
		System.out.println("Enter the driving distance in miles:");
		
		Scanner input = new Scanner(System.in);
		distance = input.nextDouble();
		
		System.out.println("Enter the miles per gallon:");
		
		Scanner input1 = new Scanner(System.in);
		milesPergallon = input1.nextDouble();
		
		System.out.println("Enter the price of gas per gallon:");
		
		Scanner input2 = new Scanner(System.in);
		pricePergallon = input2.nextDouble();
		
		double tripCost = (distance / milesPergallon) * pricePergallon;
		
		System.out.println("The cost of driving for this trip is: $" + tripCost );
		
	}

}
