package ch_08;

/**
 * 8.10 (Largest row and column) Write a program that randomly fills in 0s and 1s into
 * a 4-by-4 matrix, prints the matrix, and finds the first row and column with the
 * most 1s. Here is a sample run of the program:
 * 0011
 * 0011
 * 1101
 * 1010
 * The largest row index: 2
 * The largest column index: 2
 */
public class Exercise08_10 {
    public static void main(String[] args) {

        final int size = 4;

        int[][] randomMatrix = new int[size][size];

        for (int i = 0; i < randomMatrix.length; i++) {
            for (int j = 0; j < randomMatrix[i].length; j++) {
                randomMatrix[i][j] = (int) (Math.random() * 2);
            }
        }

        for (int i = 0; i < randomMatrix.length; i++) {
            for (int j = 0; j < randomMatrix[i].length; j++) {
                System.out.print(randomMatrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("The largest row index is: " +
                findLargerow(randomMatrix));

        System.out.println("The largest column index is: " +
                findLargecolumn(randomMatrix));


    }

    public static int findLargecolumn(int[][] a) {

        int largeColumn = 0;
        int largeSum = a[0][0] + a[1][0] + a[2][0] + a[3][0];
        int Sum = 0;

        for (int i = 1; i < a[0].length; i++) {

            Sum = a[0][i] + a[1][i] + a[2][i] + a[3][i];
            if (Sum > largeSum) {
                largeSum = Sum;
                largeColumn = i;
            }
        }
        return largeColumn;

    }

    public static int findLargerow(int[][] a) {

        int largeRow = 0;
        int largeSum = a[0][0] + a[0][1] + a[0][2] + a[0][3];
        int Sum = 0;

        for (int i = 1; i < a.length; i++) {

            Sum = a[i][0] + a[i][1] + a[i][2] + a[i][3];
            if (Sum > largeSum) {
                largeSum = Sum;
                largeRow = i;
            }

        }

        return largeRow;
    }

}
