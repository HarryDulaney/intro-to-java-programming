package fav_code_challenges;

import java.util.Arrays;

/**
 * Given a two dimensional array of points where each points represents a pixel
 * in an image and an integer "flag" which is 0 or 1. If flag is 0 rotate the image
 * 90 degrees clockwise. If flag is 1 rotate the image 90 degrees
 * counter-clockwise. Output the result to STDOUT.
 *
 *                                           Scratch Paper:
 * ----------------------------- (Counter-Clockwise - Array indexes mapping) ------------------------------
 *                          testArray    (Correct Result)       (testArray)          (Correct result)
 *  pixels = new int[][] { { 1, 2, 3},     {{3, 6, 9}       [0][0],[0][1],[0][2] -> [2][0],[1][0],[0][0]
 *                         {4, 5, 6},      {2, 5, 8}        [1][0],[1][1],[1][2] -> [2][1],[1][1],[0][1]
 *                         {7, 8, 9}};     {1, 4, 7}}       [2][0],[2][1],[2][2] -> [2][2],[1][2],[0][2]
 * ---------------------------------------------------------------------------------------------------------
 *
 * @author Harry D.
 */
public class RotateTwoDimArray {

    private static int flag;
    private static int[][] pixels;
    private static int rows;
    private static int columns;

    /* ********************************************** Test **************************************************** */
    static {
        flag = (int) Math.round(Math.random());
        pixels = new int[][]{{8, 8, 8, 8, 8, 8, 8, 8},
                             {7, 7, 7, 7, 7, 7, 7, 7},
                             {6, 6, 6, 6, 6, 6, 6, 6},
                             {5, 5, 5, 5, 5, 5, 5, 5},
                             {4, 4, 4, 4, 4, 4, 4, 4},
                             {3, 3, 3, 3, 3, 3, 3, 3},
                             {2, 2, 2, 2, 2, 2, 2, 2},
                             {1, 1, 1, 1, 1, 1, 1, 1}};
        rows = pixels.length;
        columns = pixels[0].length;

    }

    public static void main(String... args) {
        // clockwise
        if (flag == 0) {
            pixels = rotateClockwise(pixels, rows, columns);
            for (int i = 0; i < pixels.length; i++)
                System.out.println(Arrays.toString(pixels[i]));


            // counterclockwise
        } else if (flag == 1) {
            pixels = rotateCounterClockwise(pixels, rows, columns);
            for (int i = 0; i < pixels.length; i++)
                System.out.println(Arrays.toString(pixels[i]));

        }

    }

    private static int[][] rotateCounterClockwise(int[][] pixs, int row, int col) {
        int[][] res = new int[col][row]; // rows become columns, columns become rows

        for (int r = 0; r < row; r++) {
            for (int c = 0, j = res[r].length - 1; c < col && j >= 0; c++, j--) {
                res[j][r] = pixs[r][c];
            }

        }

        return res;


    }

    private static int[][] rotateClockwise(int[][] pixs, int row, int col) {
        int[][] res = new int[col][row]; // rows become columns,columns become rows

        for (int r = 0, i = res[r].length - 1; r < row && i >= 0; r++, i--) {
            for (int c = 0; c < col; c++) {
                res[c][i] = pixs[r][c];
            }
        }

        return res;

    }

}
