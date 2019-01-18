package Ch_2;

import java.util.Scanner;

//Reads an integer and adds the digits in the integer

public class Exercise02_06 {
	public static void main(String[]args) {
		
System.out.println("Enter an integer between 0 and 1000");
		
		Scanner input = new Scanner(System.in);
		
		int x;
		
		x = input.nextInt();
		
		int a = x % 10;
		
		int b = (x / 10) % 10;
		
		int c = x/ 100;
		
		System.out.println(a+b+c);
		
	
	
	}

}
