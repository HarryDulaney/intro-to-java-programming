package ch_05;

import java.util.Scanner;

public class E0514 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the first positive integer: ");
		int n1 = input.nextInt();
		
		System.out.println("Enter the second positive integer: ");
		int n2 = input.nextInt();
		
		int gcd = n1 < n2 ? n1 : n2;
		
		while( n1 % gcd != 0 || n2 % gcd != 0) {
			gcd--;
		}
		System.out.println("The GCD of " + n1 + " and " + n2 + " is " + gcd);
		
		
		
	}

}
