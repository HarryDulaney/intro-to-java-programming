package ch_08;

import java.util.Scanner;

/**
 * 8.5 (Algebra: add two matrices)
 * Write a method to add two matrices.
 * The header of the method is as follows:
 * <p>
 * public static double[][] addMatrix(double[][] a, double[][] b)
 * <p>
 * In order to be added, the two matrices must have the same dimensions
 * and the same or compatible types of elements. Let c be the resulting
 * matrix. Each element cij is aij + bij. For example,
 * for two 3 � 3 matrices a and b, c is
 * <p>
 * Write a test program that prompts the user to
 * enter two 3 � 3 matrices and displays their sum.
 */
public class Exercise08_05 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter matrix one now: ");

        double[][] matrix1 = new double[3][3];

        for (int i = 0; i < matrix1.length; i++) {

            for (int j = 0; j < matrix1[i].length; j++) {

                matrix1[i][j] = input.nextDouble();
            }
        }

        System.out.println("Enter matrix two now: ");

        double[][] matrix2 = new double[3][3];

        for (int i = 0; i < matrix2.length; i++) {

            for (int j = 0; j < matrix2[i].length; j++) {

                matrix2[i][j] = input.nextDouble();
            }
        }
        double[][] newMatrix = addMatrix(matrix1, matrix2);

        System.out.println("The addition of the matrices is: ");

        for (int i = 0; i < matrix1.length; i++) {


            for (int j = 0; j < matrix1[i].length; j++) {

                System.out.print(matrix1[i][j] + " ");
                if (i == 1 && j == 2) {
                    System.out.print(" +   ");
                } else if (i != 1 && j == 2)
                    System.out.print("     ");
            }

            for (int j = 0; j < matrix2[i].length; j++) {

                System.out.print(matrix2[i][j] + " ");
                if (i == 1 && j == 2) {
                    System.out.print(" =   ");
                } else if (i != 1 && j == 2)
                    System.out.print("     ");
            }

            for (int j = 0; j < newMatrix[i].length; j++) {

                System.out.print(newMatrix[i][j] + " ");
                if (i != 1 && j == 2)
                    System.out.print("    ");
            }
            System.out.println();

        }

    }

    public static double[][] addMatrix(double[][] a, double[][] b) {

        double[][] sum = new double[3][3];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[i].length; j++) {

                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        return sum;

    }

}
