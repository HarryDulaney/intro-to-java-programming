package ch_08;

import java.util.*;

/**
 * *8.24 (Check Sudoku solution) Listing 8.4 checks whether a solution is valid by checking whether every number is valid in the board.
 * Rewrite the program by checking whether every row, every column,
 * and every small box has the numbers 1 to 9.
 *
 */
public class Exercise08_24 {
    static boolean useTestData = true;

    static int[][] test = new int[][]{
            {9, 6, 3, 1, 7, 4, 2, 5, 8,},
            {1, 7, 8, 3, 2, 5, 6, 4, 9},
            {2, 5, 4, 6, 8, 9, 7, 3, 1},
            {8, 2, 1, 4, 3, 7, 5, 9, 6},
            {4, 9, 6, 8, 5, 2, 3, 1, 7},
            {7, 3, 5, 9, 6, 1, 8, 2, 4},
            {5, 8, 9, 7, 1, 3, 3, 6, 2},
            {3, 1, 7, 2, 4, 6, 9, 8, 5},
            {6, 4, 2, 5, 9, 8, 1, 7, 3}};

    public static void main(String[] args) {
        int[][] grid;

        // Read a Sudoku solution
        if (useTestData) {
            grid = Exercise08_24.test;
        } else {
            grid = readASolution();
        }
        System.out.println(isValid(grid) ? "Valid solution" :
                "Invalid solution");
    }

    /**
     * Read a Sudoku solution from the console
     */
    public static int[][] readASolution() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Sudoku puzzle solution:");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = input.nextInt();
        return grid;
    }

    /**
     * Check whether a solution is valid
     */
    public static boolean isValid(int[][] grid) {
        int[] tracker = new int[9];
        // Check rows
        for (int i = 0; i < 9; i++) {
            Arrays.fill(tracker, 0); //Reset to 0's to track next row
            for (int j = 0; j < 9; j++) {
                int cell = grid[i][j];
                if (tracker[cell - 1] != 0) { //tracker[] has already recorded a value for grid[i][j] for row i
                    return false;
                } else {
                    tracker[cell - 1] = 1;

                }
            }
        }
        // Check columns
        for (int i = 0; i < 9; i++) {
            Arrays.fill(tracker, 0);//Reset to 0's to track next column
            for (int j = 0; j < 9; j++) {
                int cell = grid[j][i];
                if (tracker[cell - 1] != 0) { //tracker[] has already recorded a value for grid[j][i] for column i
                    return false;
                } else {
                    tracker[cell - 1] = 1;
                }
            }
        }
        // Check the 3-by-3 boxes
        /* Boxes start indexes are:(0,0),(0,3),(0,6),(3,0),(3,3),(3,6),(6,0),(6,3),(6,6)*/
        for (int i = 0; i <= 6; i += 3) { // There are nine 3-by-3 boxes total
            for (int j = 0; j <= 6; j += 3) {
                if (!checkBox(grid, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkBox(int[][] grid, int startRow, int startCol) {
        int[] tracker = new int[9];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int cell = grid[startRow + r][startCol + c];
                if (tracker[cell - 1] != 0) {
                    return false;
                } else {
                    tracker[cell - 1] = 1;
                }
            }
        }
        return true;
    }
}
