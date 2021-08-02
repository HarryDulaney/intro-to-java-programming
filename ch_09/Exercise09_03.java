package ch_09;


import java.util.Date;

/**
 * *9.3 (Use the Date class) Write a program that creates a Date object, sets its elapsed
 * time to 10000, 100000, 1000000, 10000000, 100000000, 1000000000,
 * 10000000000, and 100000000000, and displays the date and time using the
 * toString() method, respectively.
 */
public class Exercise09_03 {
    private static final long startElapsedTime = 10000;
    private static final long endElapsedTime = 100000000000L;

    public static void main(String[] args) {
        Date date = new Date();
        for (long elapsedTime = startElapsedTime; elapsedTime < endElapsedTime; elapsedTime *= 10) {
            date.setTime(elapsedTime);
            System.out.println(date.toString());
        }

    }
}
