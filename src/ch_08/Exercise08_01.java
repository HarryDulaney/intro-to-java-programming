package ch_08;

/* 8.1 (Sum elements column by column) Write a method that returns the sum of 
 * all the elements in a specified column in a matrix using the following header:
 * public static double sumColumn(double[][] m, int columnIndex)
 * Write a test program that reads a 3-by-4 
 * matrix and displays the sum of each column.
 */

import java.util.Scanner;

public class Exercise08_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double[][] superArray = new double[3][4];
		
		System.out.println("Enter a 3 by 4 matrix row by row: ");
		
		for(int i = 0; i < superArray.length; i++ ) {
			for(int j = 0; j < superArray[i].length; j++) {
				superArray[i][j] = input.nextDouble();
				}	
		}
		
		System.out.println("The sum of the elements in 0 is " + sumColumn(superArray,0));
		System.out.println("The sum of the elements in 1 is " + sumColumn(superArray,1));
		System.out.println("The sum of the elements in 2 is " + sumColumn(superArray,2));
		System.out.println("The sum of the elements in 3 is " + sumColumn(superArray,3));
		input.close();
	}
	public static double sumColumn(double[][] m, int columnIndex) {
		
		double sum = 0;
		
		for( int i = 0; i < m.length; i++) {
			
			sum += m[i][columnIndex];
		}
		return sum;
		
          }
}