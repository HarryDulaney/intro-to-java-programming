package ch_05;

import java.io.FileInputStream;
import java.util.*;

/**
 * **5.17 (Display pyramid) Write a program that prompts the user to enter an integer from
 * 1 to 15 and displays a pyramid, as shown in the following sample run:
 * Enter the number of lines: 7
 * @author Harry Dulaney
 */
public class Exercise05_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");

        int numLines = in.nextInt();

        for (int i = 1; i <= numLines; i++) {
            int offsetNums = numLines - i;
            for (int s = 0; s < offsetNums; s++) {
                System.out.print("    ");
            }
            for (int leftSideNums = numLines - offsetNums; leftSideNums >= 2; leftSideNums--) {
                System.out.printf("%4d", (leftSideNums));
            }
            for (int rightSideNums = 1; rightSideNums < numLines - offsetNums + 1; rightSideNums++) {
                System.out.printf("%4d", (rightSideNums));
            }
            System.out.println();
        }
    }
}