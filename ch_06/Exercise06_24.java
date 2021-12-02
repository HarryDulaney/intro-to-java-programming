package ch_06;

/**
 * **6.24 (Display current date and time) Listing 2.7, ShowCurrentTime.java, displays the
 * current time. Improve this example to display the current date and time.
 * The calendar example in Listing 6.12, PrintCalendar.java, should give you some ideas on
 * how to find the year, month, and day.
 *
 * @author Harry D.
 */
public class Exercise06_24 {

    static int daysElapsedCurrentYear;
    static int getDaysElapsedCurrentMonth;

    public static void main(String[] args) {
        String time = getCurrentTime(System.currentTimeMillis());
        String date = getCurrentDate(System.currentTimeMillis());
        System.out.println("The current date is " + date + ". And the current time is " + time);
    }

    public static String getCurrentDate(long millis) {
        long seconds = millis / 1000;
        long min = seconds / 60;
        long hours = min / 60;
        long days = hours / 24;
        int year = getYear((int) days);
        int month = getCurrentMonth(year, daysElapsedCurrentYear);
        return month + "/" + getDaysElapsedCurrentMonth + "/" + year;
    }

    private static String getCurrentTime(long millis) {
        long seconds = millis / 1000;
        long currentSecond = seconds % 60;

        long min = seconds / 60;
        long currentMin = min % 60;

        long hours = min / 60;
        long currentHour = hours % 24;

        return currentHour + ":" + currentMin + ":" + currentSecond + "(GMT)";

    }

    public static int getYear(int totalDays) {
        int year = 1970;
        while (totalDays > 365) {
            totalDays -= numberOfDaysInAYear(year);
            year++;
            daysElapsedCurrentYear = totalDays;
        }
        return year;
    }


    public static int numberOfDaysInAYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getCurrentMonth(int year, int daysElapsedInYear) {
        int month = 0;
        while (daysElapsedInYear > 0) {
            month++;
            getDaysElapsedCurrentMonth = daysElapsedInYear;
            daysElapsedInYear -= getNumberOfDaysInMonth(year, month);

        }
        return month;

    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0;
    }
}