package ch_02;


import java.util.Scanner;

/**
 * 2.7 (Find the number of years)
 * Write a program that prompts the user to enter
 * the minutes (e.g., 1 billion), and displays the number
 * of years and days for the minutes. For simplicity, assume
 * a year has 365 days.
 */
public class Exercise02_07 {
    public static void main(String[] args) {

        final int minInhour = 60;
        final int hoursInday = 24;
        final int daysInyear = 365;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of minutes: ");

        int numberOfmin = input.nextInt();

        int numberOfyears = numberOfmin / minInhour / hoursInday / daysInyear;

        int numberOfdays = numberOfmin / minInhour / hoursInday % daysInyear;

        System.out.println(numberOfmin + " minutes is approximately " + numberOfyears + " years and " + numberOfdays + " days");

    }

}
