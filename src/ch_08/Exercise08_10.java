package ch_08;
/*8.10 (Largest row and column) Write a program that randomly fills in 0s 
 * and 1s into a 4-by-4 matrix, prints the matrix, and finds the first row 
 * and column with the most 1s. Here is a sample run of the program:
 */

public class Exercise08_10 {
	public static int findLargestcolumn(int[][]a) {
		
		int largestCol = 0;
		int largeSum = a[0][0] + a[1][0] + a[2][0] + a[3][0];
		int Sum = 0;
		
		for (int i = 1; i < a[0].length;i++) {
			
			Sum = a[0][i] + a[1][i] + a[2][i] + a[3][i];
			if(Sum > largeSum) {
				largeSum = Sum;
				largestCol = i;
			}
		}
		return largestCol;
		
	}
	public static int findLargestrow(int[][]a) {
		
		int largestRow = 0;
		int largeSum = a[0][0] + a[0][1] + a[0][2] +a[0][3];
		int Sum = 0;
		
		for (int i = 1; i < a.length; i++) {
			
			Sum = a[i][0] + a[i][1] + a[i][2]+ a[i][3];
			if (Sum > largeSum) {
				largeSum = Sum;
				largestRow = i;
			}
			
		}
		
		return largestRow;
	}
	
	
	public static void main(String[] args) {
		
		final int D = 4;
		
		int[][] randoMatrix = new int [D][D];
		
		for (int row = 0; row < randoMatrix.length; row++) {
			for (int column = 0; column < randoMatrix[row].length; column++) {
				randoMatrix[row][column] = (int)(Math.random() * 2);
			}
		}
		
		for (int i = 0; i < randoMatrix.length; i++) {
			for (int j = 0; j < randoMatrix[i].length; j++) {
				System.out.print(randoMatrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("The largest row index is: "+
		findLargestrow(randoMatrix));
		
		System.out.println("The largest column index is: "+ 
		findLargestcolumn(randoMatrix));
		
		
		
		
	}

}
