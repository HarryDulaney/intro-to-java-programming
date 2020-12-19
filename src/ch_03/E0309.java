package ch_03; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * **3.9 (Business: check ISBN-10) An ISBN-10 (International Standard Book
 * Number) consists of 10 digits: d1d2d3d4d5d6d7d8d9d10. The last digit, d10, is
 * a checksum, which is calculated from the other nine digits using the
 * following formula: (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7
 * * 7 + d8 * 8 + d9 * 9) % 11 If the checksum is 10, the last digit is denoted
 * as X according to the ISBN-10 convention.
 * 
 * Write a program that prompts the user to enter the first 9 digits and
 * displays the 10-digit ISBN (including leading zeros). Your program should
 * read the input as an integer.
 *
 * @author Harry Dulaney
 */
public class E0309 {

	public static void main(String[] args) {
		System.out.print("Enter the first 9 digits of an ISBN-10 number: ");
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.length() > 9 || line.length() < 9) {
					throw new IllegalArgumentException(
							"Please enter exactly the first nine digits of the isbn number...");
				}
				StringBuilder sb = new StringBuilder(line);
				line = sb.reverse().toString();
				int isbn = Integer.parseInt(line);
				int temp = isbn;
				int t = 0;
				int sum = 0;
				int d10 = 0;
				for (int i = 1; i <= 9; i++) {
					int x = temp % 10;
					
					System.out.print("d" + i + " = " + x + " ->: ");
					t = x * i;
					
					System.out.println("d" + i + " * " + i + " -> " + x + " * " + i + " = " + t);

					System.out.println("sum = " + sum + " + " + t);
					sum += t;
					System.out.println("sum = " + sum);

					temp /= 10;
				}
				d10 = sum % 11;
				System.out.println("d10 = sum % 11 -> " + d10 + " = " + sum + " % 11");

				if (d10 == 10) {
					line = line + "X";
				} else {
					line = line + d10;
				}
				System.out.println("The ISBN-10 number is: " + line);

			}
		} catch (IllegalArgumentException ie) {
			System.out.println(ie.getMessage());
			ie.printStackTrace();

		} catch (IOException e) {
			System.out.print("IOException while reading user input from console.");
			e.printStackTrace();
		}

	}

}
