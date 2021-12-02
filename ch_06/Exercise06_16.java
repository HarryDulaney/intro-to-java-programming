package ch_06;

/**
 * *6.16 (Number of days in a year) Write a method that returns the number of days in a
 * year using the following header:
 * public static int numberOfDaysInAYear(int year)
 * Write a test program that displays the number of days in year from 2000 to 2020.
 *
 * @author Harry Dulaney
 */
public class Exercise06_16 {
    public static void main(String[] args) {
        System.out.println("Year           Total Days");
        System.out.print("__________________________");
        for (int yr = 2000; yr <= 2020; yr++) {
            System.out.print("\n" + yr + "              " + numberOfDaysInAYear(yr));

        }
    }

    public static int numberOfDaysInAYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}