package ch_22;

import java.util.Scanner;

/**
 * 22.1 (Maximum consecutive increasingly ordered substring) Write a program that
 * prompts the user to enter a string and displays the maximum consecutive
 * increasingly ordered substring. Analyze the time complexity of your program.
 * Here is a sample run:
 * Enter a string:abcabcdgabxy
 * abcdg
 * <p>
 * Enter a string: abcabcdgabmnsxy
 * abmnsxy
 * <p>
 * _____________________________________________
 * Time complexity is O(n) because the program
 * will always loop through the entire input string.
 * The time will always grow proportionally to the size
 * of the input string.
 */
public class Exercise22_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String base = input.next();
        int p1 = 0; // Start substring pointer
        String maxSub = "";
        for (int i = 1; i < base.length(); i++) {
            String testSub = base.substring(p1, i + 1);
            if (testSubstring(testSub)) {
                if (testSub.length() > maxSub.length()) {
                    maxSub = testSub;
                }
            } else {
                p1++;
            }
        }
        System.out.println(maxSub);

        input.close();
    }

    static boolean testSubstring(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
