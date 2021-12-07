package ch_08;

import java.util.*;

/**
 * **8.11 (Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix
 * with some face up and some face down. You can represent the state of the
 * coins using a 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are
 * some examples: 0 0 0 1 0 1 1 1 0 1 0 1 1 0 0 0 1 0 0 0 1 1 0 0 1 1 0 1 1 1 0
 * 0 0 1 0 0 0 0 1 1 0 0 1 1 0 Each state can also be represented using a binary
 * number. For example, the preceding matrices correspond to the numbers
 * 000010000 101001100 110100001 101110100 100111110 There are a total of 512
 * possibilities, so you can use decimal numbers 0, 1, 2, 3, . . . , and 511 to
 * represent all states of the matrix. Write a program that prompts the user to
 * enter a number between 0 and 511 and displays the corresponding matrix with
 * the characters H and T.
 * <p>
 * Here is a sample run: Enter a number between 0 and 511: 7
 * <p>
 * H H H H H H T T T
 * <p>
 * The user entered 7, which corresponds to 000000111. Since 0 stands for H and
 * 1 for T, the output is correct. (e.g) count from 1 to 7: 000 001 010 011 100
 * 101 110 111
 */
public class Exercise08_11 {
    char[] coins = new char[9];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 511: ");
        int userNum = input.nextInt();
        String binStr = Integer.toBinaryString(userNum);
        Exercise08_11 obj = new Exercise08_11();
        obj.handleCoins(binStr);
        input.close();
    }

    void handleCoins(String binStr) {
        String zerosStr = "";
        int zeros = 9 - binStr.length();

        for (int i = 1; i <= zeros; i++) {
            zerosStr += "0";
        }
        String completeBinStr = zerosStr.concat(binStr);
        System.out.println(completeBinStr);

        for (int i = 0; i < 9; i++) {

            coins[i] = completeBinStr.charAt(i);
        }
        for (int i = 0, j = 1; i < 9; i++, j++) {
            String str = String.valueOf(coins[i]);
            System.out.print(str.contentEquals("1") ? "T" : "H");
            if (j % 3 == 0) {
                System.out.println();
            }

        }

    }
}