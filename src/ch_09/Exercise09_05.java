package ch_09;

import java.util.GregorianCalendar;

/**
 * *9.5 (Use the GregorianCalendar class) Java API has the GregorianCalendar class
 * in the java.util package, which you can use to obtain the year, month, and day of a
 * date. The no-arg constructor constructs an instance for the current date,
 * and the methods get(GregorianCalendar.YEAR), get(GregorianCalendar.MONTH),
 * and get(GregorianCalendar.DAY_OF_MONTH) return the year, month, and day.
 * Write a program to perform two tasks:
 * ■ Display the current year, month, and day.
 * ■ The GregorianCalendar class has the setTimeInMillis(long), which
 * can be used to set a specified elapsed time since January 1, 1970. Set the value
 * to 1234567898765L and display the year, month, and day.
 */
public class Exercise09_05 {

    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        int month = gregorianCalendar.get(GregorianCalendar.MONTH);
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println("Display the current year, month, and day: ");
        System.out.println("Year: " + year + ", Month: " + month + ", Day of month: " + day);

        System.out.println("Setting GregorianCalendar.setTimeInMillis(long) to 1234567898765L");

        gregorianCalendar.setTimeInMillis(1234567898765L);
        year = gregorianCalendar.get(GregorianCalendar.YEAR);
        month = gregorianCalendar.get(GregorianCalendar.MONTH);
        day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println("Year: " + year + ", Month: " + month + ", Day of month: " + day);

    }
}
