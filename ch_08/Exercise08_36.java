package ch_08;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * **8.36 (Latin square) A Latin square is an n-by-n array filled with n different Latin letters,
 * each occurring exactly once in each row and once in each column.
 * <p>
 * Write a program that prompts the user to enter the number n and the array of characters,
 * as shown in the sample output, and checks if the input array is a Latin square.
 * The characters are the first n characters starting from A.
 * Enter number n: 3
 * Enter 3 rows of letters separated by spaces:
 * A F D
 * Wrong input: the letters must be from A to C
 * <p>
 * Enter number n: 4
 * Enter 4 rows of letters separated by spaces:
 * A B C D
 * B A D C
 * C D B A
 * D C A B
 * The input array is a Latin square
 *
 * @author Harry Dulaney
 */
public class Exercise08_36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean result = true;
        System.out.print("\nEnter number n: ");
        int numRows = in.nextInt();
        final int minChar = 'A';
        List<Integer> rowTracker = new ArrayList<>();
        List<Integer> colTracker = new ArrayList<>();
        char[][] chars = new char[numRows][numRows];

        int upperBoundChar = minChar + numRows - 1; //Upper Bound for the range from 'A' -> ('A' + userInput)
        System.out.println("\nEnter " + numRows + " rows of capital letters separated by spaces: ");
        try {
            for (int r = 0; r < chars.length; r++) {
                for (int c = 0; c < chars[r].length; c++) {
                    String strCh = in.next();
                    chars[r][c] = strCh.charAt(0);
                }
            }
            for (int r = 0; r < chars.length; r++) {
                System.out.println(Arrays.toString(chars[r]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
            System.out.println("The input array is not a Latin Square.");
            System.exit(0);
        }

        ROW:
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].length != numRows) {
                System.out.println("Invalid input: Line " + i + " has length of " + chars[i].length + ",but should " +
                        "have a length of " + numRows);
                result = false;
                break;
            }

            if (rowTracker.size() > 0) {
                rowTracker.clear();
            }
            for (int j = 0; j < chars[i].length; j++) {
                int charValue = chars[i][j];
                if (charValue < minChar || charValue > upperBoundChar) {
                    System.out.println("Invalid input: Letters should be between " + minChar + " and " + upperBoundChar);
                    break ROW;

                } else if (rowTracker.size() != 0) {
                    if (rowTracker.contains(charValue)) {
                        System.out.println("The input array is not a Latin Square.");
                        result = false;
                        break ROW;
                    }
                }
                rowTracker.add(charValue);

            }

        }
        if (result) {
            OUTER:
            for (int column = 0; column < numRows; column++) {
                if (column > 0) {
                    colTracker.clear();
                }
                for (int row = 0; row < chars.length; row++) {
                    int value = chars[row][column];

                    if (colTracker.size() > 0) {
                        if (colTracker.contains(value)) {
                            System.out.println("The input array is not a Latin Square.");
                            break OUTER;
                        }
                    }
                    colTracker.add(value);
                }
            }
        }
        in.close();
    }
}