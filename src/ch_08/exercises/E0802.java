package ch_08.exercises;

/*8.2 (Sum the major diagonal in a matrix) Write a method that 
 *sums all the numbers in the major diagonal in an n � n matrix
 *of double values using the following header:
 * Write a test program that reads a 4-by-4 matrix and
 * displays the sum of all its elements on the major diagonal. 
 */
import java.util.Scanner;

public class E0802 {
	public static double sumMajorDiagonal(double[][] m) {
		
		double sum = 0;
		int row = 0;
		
			for (int column = 0; column < m.length; column++) {
				
				sum += m[row++][column];
			}
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double[][] fourByfour = new double [4][4];
		
		System.out.println("Enter a 4 by 4 matrix row by row: ");
		
		for (int row = 0; row < fourByfour.length; row++) {
			for(int column = 0; column < fourByfour[row].length; column++) {
				
				fourByfour[row][column] = input.nextDouble();	
			}
		}
		input.close();
		System.out.println("The sum of the elements in the major diagonal is"
				+ ": " + sumMajorDiagonal(fourByfour));
	}

}
