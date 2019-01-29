package Ch_08;

/* 8.1 (Sum elements column by column) Write a method that returns the 
 * sum of all the elements in a specified column in a matrix using the 
 * following header:
 * Write a test program that reads a 3-by-4 matrix and displays the sum of each column.
 * Here is a sample run:
 */

import java.util.Scanner;

public class Exercise08_01 {
	public static double sumColumn(double[][] m, int columnIndex) {
		
		double answer = 0;
		
		for (int i = 0; i < m.length; i++) {
			answer += m[i][columnIndex];
			
		}
			
		return answer;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double[][] array = new double [3][4];
		
		System.out.println("Enter a 3 by 4 matrix, row by row: ");
		
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length;column++) {
				array[row][column] = input.nextDouble();
			}
		}
		
		System.out.println("The sum of elements in 0 is: " + sumColumn(array,0));
		System.out.println("The sum of elements in 1 is: " + sumColumn(array,1));
		System.out.println("The sum of elements in 2 is: " + sumColumn(array,2));
		System.out.println("The sum of elements in 3 is: " + sumColumn(array,3));
	}

}
