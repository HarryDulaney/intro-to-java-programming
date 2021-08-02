package ch_03;

import java.util.*;

/**
 * **3.21 (Science: day of the week) Zeller’s congruence is an algorithm
 * developed by Christian Zeller to calculate the day of the week.
 * <p>
 * The formula is h = ¢q + 26(m10+ 1) + k + 4k + 4j + 5j≤ % 7 where ■ h is the day of the
 * week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5:
 * Thursday, 6: Friday). ■ q is the day of the month. ■ m is the month (3:
 * March, 4: April, …, 12: December). January and February are counted as months
 * 13 and 14 of the previous year. ■ j is the century (i.e., year 100 ). ■ k is
 * the year of the century (i.e., year % 100).
 * <p>
 * Note that the division in the formula performs an integer division.
 * <p>
 * Write a program that prompts the user to enter a year, month, and day of the month, and displays the name of the
 * day of the week. Here are some sample runs:
 * <p>
 * Enter year: (e.g., 2012): 2015
 * Enter month: 1-12: 1
 * Enter the day of the month: 1-31: 21
 * <p>
 * 25 Day of the week is Sunday
 * <p>
 * Enter year: (e.g., 2012): 2012 Enter month: 1-12: 5
 * Enter the day of the month: 1-31: 12
 * <p>
 * Day of the week is Saturday
 * <p>
 * <p>
 * (Hint: January and February
 * are counted as 13 and 14 in the formula, so you need to convert the user
 * input 1 to 13 and 2 to 14 for the month and change the year to the previous
 * year.)
 *
 *
 */
public class Exercise03_21 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter year: (e.g., 2012): ");
        int year = in.nextInt();

        System.out.print("\nEnter month: 1-12: ");
        int temp = in.nextInt();

        int m;
        if (temp == 1) {
            m = 13;
            year -= 1;
        } else if (temp == 2) {
            m = 14;
            year -= 1;
        } else {
            m = temp;
        }

        int k = year % 100;
        int j = year / 100;

        System.out.print("\nEnter the day of the month: 1-31:");
        int q = in.nextInt();
        int h = (q + ((26 * (m + 1)) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

        String dayOfWeek = "";

        switch (h) {
            case 0:
                dayOfWeek += "Saturday";
                break;
            case 1:
                dayOfWeek += "Sunday";
                break;
            case 2:
                dayOfWeek += "Monday";
                break;
            case 3:
                dayOfWeek += "Tuesday";
                break;

            case 4:
                dayOfWeek += "Wednesday";
                break;

            case 5:
                dayOfWeek += "Thursday";
                break;

            case 6:
                dayOfWeek += "Friday";
                break;
        }
        System.out.print("\nDay of the week is " + dayOfWeek);


        in.close();
    }

}