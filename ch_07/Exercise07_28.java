package ch_07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * *7.28 (Math: combinations) Write a program that prompts the user to enter 10 integers
 * and displays all combinations of picking two numbers from the 10.
 *
 * @author Harry.
 */
public class Exercise07_28 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter ten integers: ");
        String[] line = in.nextLine().split("\\s+");

        for (int p1 = 0; p1 < line.length; p1++) {
            for (int p2 = 0; p2 < line.length; p2++) {
                if (p1 != p2) {
                    System.out.println(Arrays.toString(nextSet(line, p1, p2)));
                }

            }

        }
        in.close();
    }

    static String[] nextSet(String[] nums, int p1, int p2) {
        return new String[]{nums[p1], nums[p2]};
    }
}
