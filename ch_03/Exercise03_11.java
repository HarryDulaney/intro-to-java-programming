package ch_03;

import java.util.Scanner;

/**
 * *3.11 (Find the number of days in a month) Write a program that prompts the
 * user to enter the month and year and displays the number of days in the
 * month. For example, if the user entered month 2 and year 2012, the program
 * should display that February 2012 had 29 days. If the user entered month 3
 * and year 2015, the program should display that March 2015 had 31 days.
 *
 */
public class Exercise03_11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the month as an integer fro 1 to 12: ");
        int month = in.nextInt();

        System.out.print("Enter the year: ");
        int year = in.nextInt();
        final String commonOutput = "The number of days in the month is ";
        String days = "";

        switch (month) {
            case 1:
                days = "31";
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = "28";
                } else {
                    days = "29";
                }
                break;
            case 3:
                days = "31";
                break;
            case 4:
                days = "30";
                break;
            case 5:
                days = "31";
                break;
            case 6:
                days = "30";
                break;
            case 7:
                days = "31";
                break;
            case 8:
                days = "31";
                break;
            case 9:
                days = "30";
                break;
            case 10:
                days = "31";
                break;
            case 11:
                days = "30";
                break;
            case 12:
                days = "31";
                break;
        }
        System.out.println(commonOutput + days);
        in.close();
    }

}
