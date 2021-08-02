package ch_05;

import java.util.*;

/**
 * **5.28 (Display the first days of each month) Write a program that prompts the user to
 * enter the year and first day of the year, and displays the first day of each month
 * in the year. For example, if the user entered the year 2013, and 2 for Tuesday,
 * January 1, 2013, your program should display the following output:
 * January 1, 2013 is Tuesday
 * ...
 * December 1, 2013 is Sunday
 */
public class Exercise05_27 {
    public static void main(String[] args) {

        int i = 1;
        for (int year = 2001; year <= 2100; year++) {

            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                System.out.print(year + " ");
                if (i % 10 == 0) {
                    System.out.println();
                }
                i++;
            }

        }
    }
}