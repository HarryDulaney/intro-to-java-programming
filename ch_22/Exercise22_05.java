package ch_22;

import java.util.Scanner;

/**
 * 22.5 (Same-number subsequence) Write an O(n) program that prompts the user to
 * enter a sequence of integers ending with 0 and finds the longest subsequence
 * with the same number. Here is a sample run of the program:
 * Enter a series of numbers ending with 0:
 * 2 4 4 8 8 8 8 2 4 4 0
 * The longest same number sequence starts at index 3 with 4 values of 8
 */
public class Exercise22_05 {
    private void findSubsequence(String[] tokens) {
        int longest = 0;
        int longestStartIndex = 0;
        int count = 1;
        int value = 0;
        int startIndex = 0;

        for (int i = 0; i < tokens.length - 1; i++) {
            int curr = Integer.parseInt(tokens[i]);
            int next = Integer.parseInt(tokens[i + 1]);
            if (next == 0) break;
            if (curr == next) {
                count++;
                longest = Math.max(longest, count);
                if (count == longest) {
                    value = curr;
                    longestStartIndex = startIndex;
                }
            } else {
                startIndex = i + 1;
                count = 1;
            }

        }
        System.out.println("The longest same number sequence starts at index " + longestStartIndex +
                " with " + longest + " values " + "of " + value);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a series of numbers ending with 0:");
        String[] tokens = input.nextLine().split("\\s+");
        new Exercise22_05().findSubsequence(tokens);

        input.close();

    }
}
