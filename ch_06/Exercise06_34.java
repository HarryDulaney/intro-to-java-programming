package ch_06;

import java.util.*;

/**
 * **6.34 (Print calendar) Programming Exercise 3.21 uses Zeller’s congruence to calculate the day of the week.
 * <p>
 * <p>
 * Simplify Listing 6.12, PrintCalendar.java, using Zeller’s
 * algorithm to get the start day of the month.
 */
public class Exercise06_34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = in.nextInt();
        System.out.print("Enter month as number between 1 and 12: ");
        int month = in.nextInt();

        printCalendarHeader(month, year);
        printFirstDay(month, year);
        printCalendar(month, year);
    }

    public static void printCalendarHeader(int month, int year) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.print("\t\t" + months[month - 1] + "\t");
        System.out.println(year);
        System.out.println("---------------------------");

        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
    }

    public static void printFirstDay(int month, int year) {
        int firstDay = zellersAlgo(1, month, year);

        String leadingTabs = "1";


        for (int i = 1; i < firstDay; i++) {
            leadingTabs = "\t" + leadingTabs;
        }
        if (firstDay == 0) {
            leadingTabs = "\t\t\t\t\t\t1";
        }

        System.out.print(leadingTabs + "\t");
    }

    public static void printCalendar(int month, int year) {

        int lastDayOfMonth = lastDayOfMonth(month, year);

        for (int i = 2; i <= lastDayOfMonth; i++) {
            int printedDay = zellersAlgo(i, month, year);
            if (printedDay == 1) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }

    /**
     * {@code zellersAlgo(int dayOfMonth, int month, int year)}
     *
     * @param dayOfMonth input day of month
     * @param month      input month
     * @param year       input year
     * @return day of the week
     */
    public static int zellersAlgo(int dayOfMonth, int month, int year) {
        if (month == 1 || month == 2) {
            month = month + 12;
            year--;
        }
        int q, m, j, k;
        q = dayOfMonth;
        m = month;
        j = year / 100;
        k = year % 100;
        return (q + (26 * (m + 1) / 10) + k + k / 4 + j / 4 + (5 * j)) % 7;

    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static int lastDayOfMonth(int month, int year) {
        int lastDayOfMonth;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            lastDayOfMonth = 31;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                lastDayOfMonth = 29;
            } else {
                lastDayOfMonth = 28;
            }
        } else {
            lastDayOfMonth = 30;
        }
        return lastDayOfMonth;
    }
}