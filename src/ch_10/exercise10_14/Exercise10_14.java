package ch_10.exercise10_14;

/**
 * Write a test program that creates two MyDate objects (using new MyDate() and new
 * MyDate(34355555133101L)) and displays their year, month, and day.
 * (Hint: The first two constructors will extract the year, month, and day from
 * the elapsed time. For example, if the elapsed time is 561555550000 milliseconds, the year is 1987, the month is 9, and the day is 18. You may use the
 * GregorianCalendar class discussed in Programming Exercise 9.5 to simplify coding.)
 */
public class Exercise10_14 {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate();
        MyDate myDate2 = new MyDate(34355555133101L);
        MyDate myDate3 = new MyDate(561555550000L);

        System.out.println("MyDate1:\n year=" + myDate1.getYear() + "\n month=" + myDate1.getMonth() + "\n day=" + myDate1.getDay());
        System.out.println("MyDate2:\n year=" + myDate2.getYear() + "\n month=" + myDate2.getMonth() + "\n day=" + myDate2.getDay());
        System.out.println("MyDate3:\n year=" + myDate3.getYear() + "\n month=" + myDate3.getMonth() + "\n day=" + myDate3.getDay());
    }
}
