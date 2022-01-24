package ch_22;

import java.util.Scanner;

/**
 * *22.3 (Pattern matching) Write a program that prompts the user to enter two strings
 * and tests whether the second string is a substring of the first string. Suppose
 * the neighboring characters in the string are distinct. (Don’t use the indexOf
 * method in the String class.) Analyze the time complexity of your algorithm.
 * Your algorithm needs to be at least O(n) time.
 * Here is a sample run of the program:
 * <p>
 * Enter a string s1: Welcome to Java
 * Enter a string s2: come
 * matched at index 3
 * <p>
 * __________________________________________________________________________________________
 * ----------------------------- Time Complexity Analysis -----------------------------------
 * __________________________________________________________________________________________
 * Time complexity is: O(n) (Linear Time)
 *
 * If s1.length is 100 and s2.length is 4:
 * Worst case is that the loop will execute over all values of s1 and check if index
 * of s1 matches the starting char in s2.
 *
 * T(n) = 100 * (s1 String loop) = O(n)
 *
 * So, Time complexity is O(n) because
 * as the length of the input grows, the time will increase at a linear rate
 * based on the size of s1.
 * The size of s2 is not relevant since we are only check that the string have the same starting char
 * and then if they do checking for equality of s1 substring and s2;
 *
 * --------------------------------- Additional efficiency ---------------------------------
 * This could be made more efficient by utilizing the constraint of neighboring characters must be
 * distinct, by performing a fast-forward after a negative match on s1 substring and s2, you move s1's index pointer
 * forward to the next possible match for s2 starting character before resuming the loop.
 *
 * Fast-forwarding would result in better time complexity of O(n/m) where n is length of s1 and m is length of s2;
 * __________________________________________________________________________________________
 */
public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = scanner.nextLine();
        String res = getMatchedIndex(s1, s2);
        System.out.println(res);
        scanner.close();
    }

    private static String getMatchedIndex(String s1, String s2) {
        int i1 = 0;
        int matchLength = s2.length();
        char s2Start = s2.charAt(0);
        while (i1 < s1.length()) {
            if (s1.charAt(i1) == s2Start) { // Try to match first char in s2
                String s1Sub = s1.substring(i1, i1 + matchLength);
                if (s1Sub.equals(s2)) {
                    return "matched at index " + i1;
                } else {
                    // fast-forward here
                }
            }
            i1++;
        }
        return "s2 is not a substring of s1";
    }

}
