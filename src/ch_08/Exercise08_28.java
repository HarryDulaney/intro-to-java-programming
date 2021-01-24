package ch_08;

/*8.28 (Strictly identical arrays) The two-dimensional 
 * arrays m1 and m2 are strictly identical if their corresponding 
 * elements are equal. Write a method that returns true if m1 and m2 
 * are strictly identical, using the following header:
 * 
 * public static boolean equals(int[][] m1, int[][] m2)
 * 
 * Write a test program that prompts the user to enter 
 * two 3 � 3 arrays of integers and displays whether the
 * two are strictly identical. 
 */

import java.util.Scanner;

public class Exercise08_28 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[][] m1 = new int[3][3];
		
		System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
		
		for(int i = 0; i < m1.length; i++) {
			for( int j = 0; j < m1[i].length; j++) {
				
				m1[i][j] = input.nextInt();
			}
		}
			
		int[][] m2 = new int[3][3];
		
		System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
		
		for(int i = 0; i < m2.length; i++) {
			for( int j = 0; j < m2[i].length; j++) {
				
				m2[i][j] = input.nextInt();
			}
		}
		
		if(equals(m1,m2)) {
			System.out.println("The two arrays are strictly equal!");
		}else
			System.out.println("The two arrays are NOT strictly equal :(");
		
		
	}
	public static boolean equals(int[][] m1, int[][] m2) {
		
		boolean isEqual = true;
		
		for(int i = 0; i < m1.length; i++) {

				 if(m1[i][0] != m2[i][0]) {
					isEqual = false;
					break;
				}else if(m1[i][1] != m2[i][1]) {
					isEqual = false;
					break;
				}else if(m1[i][2] != m2[i][2]) {
					isEqual = false;
					break;
				}
		}
		return isEqual;
	}

}
