package ch_05;

/**
 * 5.4 (Conversion from miles to kilometers) Write a program that displays the following table (note that 1 mile is 1.609 kilometers):
 * Miles Kilometers
 * 1 1.609
 * 2 3.218
 * ...
 * 9 14.481
 * 10 16.090
 */
public class Exercise05_04 {
    public static void main(String[] args) {

        final double MILES_PER_KILOMETERS = 1.609;

        System.out.println("Miles     Kilometers");

        for (int i = 1; i <= 10; i++) {

            System.out.printf("%-10d%4.1f\n", i, (i * MILES_PER_KILOMETERS));
        }
    }

}
