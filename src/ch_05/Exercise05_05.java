package ch_05;

import java.util.*;

/**
 * 5.5 (Conversion from kilograms to pounds and pounds to kilograms)
 * <p>
 * Write a program that displays the following two tables side by side:
 * Kilograms Pounds | Pounds Kilograms
 * 1          2.2  |    20     9.09
 * 3          6.6  |    25     11.36
 * ...
 * 197       433.4 |   510    231.82
 * 199       437.8 |   515    234.09
 * <p>
 * 1 kilogram == 2.2 pounds
 *
 */
public class Exercise05_05 {
    public static void main(String[] args) {

        System.out.println("Kilograms Pounds | Pounds Kilograms");
        for (int i = 1, j = 20; i < 200; i += 2, j += 5) {
            double calcPound = i * 2.2;
            if (i < 10) {
                System.out.print(i + "  ");
            } else if (i < 100) {
                System.out.print(i + " ");
            } else {
                System.out.print(i + "");
            }


            System.out.printf("%12.1f |", calcPound);
            System.out.printf("%4d    ", j);

            double calcKilo = j / 2.2;
            System.out.printf("%8.2f\n", calcKilo);
        }
    }
}