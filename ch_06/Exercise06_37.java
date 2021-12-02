package ch_06;

import java.util.Scanner;

/**
 * 6.37 (Format an integer) Write a method with the following header to
 * format the integer with the specified width.
 * public static String format(int number, int width)
 * The method returns a string for the number with one or more prefix 0s.
 * The size of the string is the width. For example, format(34, 4) returns 0034
 * and format(34, 5) returns 00034. If the number is longer than the width,
 * the method returns the string representation for the number.
 * For example, format(34, 1) returns 34.
 *
 * @author Harry D.
 */
public class Exercise06_37 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int number = input.nextInt();
        System.out.println("Enter the width expressed in integer format: ");
        int width = input.nextInt();
        System.out.println("The formatted number is: " + format(number, width));

    }

    public static String format(int number, int width) {
        String str = (number + "");
        if (str.length() < width) {
            for (int i = width - str.length(); i > 0; i--) {
                str = 0 + str;
            }
        }

        return str;
    }

}
