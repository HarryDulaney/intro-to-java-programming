package ch_22;

import java.util.Scanner;

/**
 * *22.2 (Maximum increasingly ordered subsequence) Write a program that prompts
 * the user to enter a string and displays the maximum increasingly ordered subsequence of characters.
 * Analyze the time complexity of your program. Here is a sample run:
 * <p>
 * Enter a string: Welcome
 * Welo
 * __________________________________________________________________________________________
 * ----------------------------- Time Complexity Analysis -----------------------------------
 * __________________________________________________________________________________________
 * Time complexity is: O(n) (Linear Time)
 * For example:
 * If input string is length 20:
 * ---- T(n) = 20 * (input string loop) = O(n) -----
 * So, Time complexity is O(n) because
 * as the length of the input grows, the time will increase at a linear rate
 * based on the size of the input.
 * __________________________________________________________________________________________
 */
public class Exercise22_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.next().trim();
        String result = "";
        char lastSeqChar = input.charAt(0);
        /* Loop always executes one time, so growth rate of time is constant as the input string gets larger */
        for (int j = 1; j < input.length(); j++) {
            if (lastSeqChar < input.charAt(j)) {
                result += lastSeqChar + "";
                lastSeqChar = input.charAt(j);
            }
        }
        result += lastSeqChar;
        System.out.println(result);

        in.close();
    }
}
