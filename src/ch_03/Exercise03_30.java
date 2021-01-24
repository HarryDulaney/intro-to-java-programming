package ch_03;

import java.awt.*;
import java.util.*;

/**
 * *3.30 (Current time) Revise Programming Exercise 2.8 to display the hour using a
 * 12-hour clock. Here is a sample run:
 * Enter the time zone offset to GMT: -5
 * The current time is 4:50:34 AM
 * <p>
 * <p>
 * <p>
 * {*2.8 (Current time) Listing 2.7, ShowCurrentTime.java, gives a program that displays
 * the current time in GMT. Revise the program so that it prompts the user to enter
 * the time zone offset to GMT and displays the time in the specified time zone.}
 *
 * @author Harry Dulaney
 */
public class Exercise03_30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the time zone offset to GMT: ");
        int offset = in.nextInt();
        boolean pm = false;

        long timeInMillis = System.currentTimeMillis();
        long secondsSinceJan1st1970 = timeInMillis / 1000;
        long second = secondsSinceJan1st1970 % 60;
        long minutesSinceJan1st1970 = secondsSinceJan1st1970 / 60;
        long minute = minutesSinceJan1st1970 % 60;
        long hoursSinceJan1st1970 = minutesSinceJan1st1970 / 60;

        System.out.println(hoursSinceJan1st1970);

        long hour = hoursSinceJan1st1970 % 24;
        hour += offset;

        if (hour > 12) {
            pm = true;
            hour -= 12;
        }

        System.out.println("Your current time is " + hour + ":" + minute + ":" + second + (pm ? " PM" : " AM"));

    }
}