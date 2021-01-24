package ch_04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * *4.17 (Days of a month) Write a program that prompts the user to enter a year and the
 * first three letters of a month name (with the first letter in uppercase) and displays
 * the number of days in the month. Here is a sample run:
 * Enter a year: 2001
 * Enter a month: Jan
 * Jan 2001 has 31 days
 */
public class Exercise04_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String year = "", month = "", days = "";
        System.out.print("\nEnter a year: ");
        try {
            year = in.next("[\\d][\\d][\\d][\\d]");

        } catch (Exception e) {
            System.out.println("Invalid input for year.");
            System.exit(0);
        }

        int nYear = Integer.parseInt(year);

        System.out.print("\nEnter a month: ");
        try {
            month = in.next("[A-Z][a-z][a-z]");
        } catch (Exception e) {
            System.out.println("Invalid input for month.");
            System.exit(1);
        }
        switch (month) {
            case "Sep":
            case "Apr":
            case "Jun":
            case "Nov":
                days += "30";
                break;
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                days += "31";
                break;
            case "Feb":
                if (nYear % 4 == 0) {
                    if (nYear % 100 == 0) {
                        if (nYear % 400 == 0) {
                            days += "29";
                        } else {
                            days += "28";
                        }
                    } else {
                        days += "29";

                    }
                } else {
                    days += "28";
                }

        }
        System.out.println(month + " " + year + " has " + days + " days.");


    }


}