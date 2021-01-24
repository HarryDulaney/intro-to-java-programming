package ch_05;

import java.util.*;

/**
 * **5.27 (Display leap years) Write a program that displays all the leap years, ten per line,
 * from 101 to 2100, separated by exactly one space.
 * <p>
 * Also display the number of
 * leap years in this period.
 */
public class Exercise05_28 {
    public static void main(String[] args) {
        System.out.println("Leap Years between 101 and 2100: ");
        int total = 0;
        for (int i = 101, lineIdx = 0; i < 2100; i++) {

            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                System.out.print(i + " ");
                lineIdx++;
                total++;
                if (lineIdx == 10) {
                    System.out.println();
                    lineIdx = 0;
                }
            }

        }
        System.out.println("Total leap years is " + total);
    }
}