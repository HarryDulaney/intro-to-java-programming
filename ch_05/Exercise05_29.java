package ch_05;

import java.util.*;

/**
 * **5.29 (Display calendars) Write a program that prompts the user to enter the year and
 * first day of the year and displays the calendar table for the year on the console. For
 * example, if the user entered the year 2013, and 2 for Tuesday, January 1, 2013,
 * your program should display the calendar for each month in the year, as follows:
 * January 2013
 * Sun Mon Tue Wed Thu Fri Sat
 * 1 2 3 4 5
 * 6 7 8 9 10 11 12
 * 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26
 * 27 28 29 30 31
 */
public class Exercise05_29 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        System.out.print("Enter the first day of the year: ");
        int startDay = input.nextInt();

        int days = 0;
        for (int month = 1; month <= 12; month++) {
            switch (month) {
                case 1:
                    System.out.println("\t\t\tJanuary " + year);
                    days = 31;
                    break;
                case 2:
                    System.out.println("\t\t\tFebruary " + year);
                    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    break;
                case 3:
                    System.out.println("\t\t\tMarch " + year);
                    days = 31;
                    break;
                case 4:
                    System.out.println("\t\t\tApril " + year);
                    days = 30;
                    break;
                case 5:
                    System.out.println("\t\t\tMay " + year);
                    days = 31;
                    break;
                case 6:
                    System.out.println("\t\t\tJune " + year);
                    days = 30;
                    break;
                case 7:
                    System.out.println("\t\t\tJuly " + year);
                    days = 31;
                    break;
                case 8:
                    System.out.println("\t\t\tAugust " + year);
                    days = 31;
                    break;
                case 9:
                    System.out.println("\t\t\tSeptember " + year);
                    days = 30;
                    break;
                case 10:
                    System.out.println("\t\t\tOctober " + year);
                    days = 31;
                    break;
                case 11:
                    System.out.println("\t\t\tNovember " + year);
                    days = 30;
                    break;
                case 12:
                    System.out.println("\t\t\tDecember " + year);
                    days = 31;
            }
            for (int t = 0; t < 30; t++) {
                System.out.print("-");
            }
            System.out.println(" \nSun Mon Tue Wed Thu Fri Sat");


            for (int i = 0; i < startDay; i++) {
                System.out.print("    ");
            }
            for (int i = 1; i <= days; i++) {
                if (i < 10) {
                    System.out.print("   " + i);
                } else {
                    System.out.print("  " + i);
                }
                if ((i + startDay) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println("");


            startDay = (startDay + days) % 7;
        }
    }
}