package Ch_02;

import java.util.Scanner;

//Prompts the user for points in a triangle and displays the area of the triangle

public class Exercise02_19 {
	public static void main(String[]args) {
		
		double x1, x2, x3, y1, y2, y3;
			
		System.out.println("Enter there points for a triangle:");
		
		Scanner input = new Scanner(System.in);
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		
		double s;
		double side1;
		double side2;
		double side3;
		
		//sqrt[(x2-x1)^2 + (y2-y1] Distance between two points
		
		side1 = Math.pow(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2), 0.5);
		
		side2 = Math.pow(Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2), 0.5);
		
		side3 = Math.pow(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2), 0.5);
	
		
		 s = (side1 + side2 + side3)/2;
		 
		 double area = Math.pow(s * (s - side1) * (s - side2)* (s - side3), 0.5);
		 
		 System.out.println("The area of the triangle is: " + area );
		
				
	}

}
