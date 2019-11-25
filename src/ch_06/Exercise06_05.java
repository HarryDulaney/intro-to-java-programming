package ch_06;


import java.util.Scanner;

public class Exercise06_05 {
	public static void displaySortedNumbers(double num1, double num2, double num3) {
		
		double temp;
		
		if(num1 > num2) {
			temp = num2;
			num2 = num1;
			num1 = temp;}
			
		else if(num2 > num3) { 
			temp = num3;
			num3 = num2;
			num2 = temp;
		
		}
		System.out.println(num1 + " " + num2 + " " + num3);
	}
	public static void main(String[] args) {
		
		double num1,num2,num3;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three numbers: ");
		
		num1 = input.nextDouble();
		num2 = input.nextDouble();
		num3 = input.nextDouble();
		
		
		displaySortedNumbers(num1,num2,num3);
		
	}
	
	
}


