package Ch_08;

/*8.5 (Algebra: add two matrices) Write a method to add two matrices. 
 * 
 * Write a test program that prompts the user to enter two 3 × 3 matrices 
 * and displays their sum. Here is a sample run:
 * 
 */
import java.util.Scanner;

public class Exercise08_05 {
	public static double[][] addMatrix(double[][] a, double[][] b){
		
		double[][] sum = new double [3][3];
		
		for(int row = 0; row < a.length; row++) {
			for(int column = 0; column < a[row].length; column++) {
				
				sum[row][column] = a[row][column] + b[row][column];
			}
		}
		
		
	return sum;	
	}
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter matrix one now: ");
		
		double[][] matrix1 = new double[3][3];
		
        for (int i = 0; i < matrix1.length; i++) {
        	
            for (int k = 0; k < matrix1[i].length; k++) {
            	
                matrix1[i][k] = input.nextDouble();
           }
          }
        
		System.out.println("Enter matrix two now: ");	
		
		double[][] matrix2 = new double [3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				matrix2[i][j] = input.nextDouble();
			}
			}
			
		
		double[][] newMatrix = addMatrix(matrix1,matrix2);
		
		System.out.println("The addition of the matrices is: ");
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				
				System.out.printf("%1.1f ",matrix1[i][j]);
			
			}
			
			System.out.println();
		}
		
		System.out.println("     +    ");
		
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				
				System.out.printf("%1.1f ",matrix2[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("     =    ");
		
		for ( int i = 0; i < newMatrix.length; i++) {
			for( int j = 0; j <newMatrix[i].length; j++) {
				
				System.out.printf("%1.1f ", newMatrix[i][j]);
			}
			System.out.println();
		}
		
		
		
		}
}


