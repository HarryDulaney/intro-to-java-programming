package Ch_2;

import java.util.Scanner;

public class Exercise02_05 {
	public static void main( String []args) {
		
		double subtotal;
		double gratuityrate;
		
		System.out.println("Enter subtotal and gratuity rate");
		
		Scanner input = new Scanner(System.in);
		
		subtotal = input.nextDouble();
		gratuityrate = input.nextDouble();
		
		System.out.println("Gratuity is " + gratuityrate/100 * subtotal);
		
		double gratuity;
		gratuity = gratuityrate/100 * subtotal;
		
		System.out.println("Total is " + (gratuity + subtotal));
		
				
				
	
		
	}

}
