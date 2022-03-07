package ch_22;


import java.util.Scanner;

/**
 * *22.4 (Pattern matching) Write a program that prompts the user to enter two strings
 * and tests whether the second string is a substring of the first string. (Don’t use
 * the indexOf method in the String class.) Analyze the time complexity of
 * your algorithm. Here is a sample run of the program:
 * <p>
 * Enter a string s1: Mississippi
 * Enter a string s2: sip
 * matched at index 6
 * <p>
 * __________________________________________________________________________________________
 * ----------------------------- Time Complexity Analysis -----------------------------------
 * __________________________________________________________________________________________
 * Time complexity is: O(n) (Linear Time)
 * <p>
 * If s1.length is 100 and s2.length is 4:
 * Worst case is that the loop will execute over all values of s1
 * <p>
 * T(n) = 100 * (s1 String loop) = O(n)
 * <p>
 * So, Time complexity is O(n) because
 * as the length of the input grows, the time will increase at a linear rate
 * based on the size of s1.
 * The size of s2 is not relevant to time complexity because we iterate based on the length of s1.
 */
public class Exercise22_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string s1: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter a string s2: ");
        String s2 = scanner.nextLine();
        int result = new Exercise22_04().indexOfSubstring(s1, s2);
        if (result == -1) {
            System.out.println("s2 is not a substring of s1...");
            return;
        }

        System.out.println("matched at index " + result);
        scanner.close();
    }

    private int indexOfSubstring(String s1, String s2) {
        int index = 0;
        int matchLength = s2.length();
        char s2Start = s2.charAt(0);
        while (index < (s1.length() - matchLength)) {
            /* Try to match first char in s2 with char at next index */
            if (s1.charAt(index) == s2Start) {
                String s1Sub = s1.substring(index, index + matchLength);
                if (s1Sub.equals(s2)) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }
}
