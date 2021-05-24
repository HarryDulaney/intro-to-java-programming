package ch_13.exercise13_19;

import java.util.Scanner;

/**
 * 13.19 (Convert decimals to fractions) Write a program that prompts the user to enter
 * a decimal number and displays the number in a fraction. Hint: read the decimal
 * number as a string, extract the integer part and fractional part from the string,
 * and use the BigInteger implementation of the {@linkplain Rational} class in Programming
 * Exercise 13.15 to obtain a rational number for the decimal number. Here are some
 * sample runs:
 * Enter a decimal number: 3.25
 * The fraction number is 13/4
 * <p>
 * Enter a decimal number: -0.45452
 * The fraction number is -11363/25000
 */
public class Exercise13_19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decVal = in.next();
        try {
            System.out.println("The fraction number is " + decimalToFraction(decVal));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        in.close();
    }

    private static String decimalToFraction(String val) throws Exception {
        boolean isNegative = val.startsWith("-");

        String[] decimalNumberParts = val.split("\\.");
        if (decimalNumberParts.length < 2) {
            throw new Exception("You must enter a decimal number like: 123.12");
        }
        if (val.startsWith("-")) {
            isNegative = true;
        }
        Rational leftSideOfDecimal = new Rational(Long.parseLong(decimalNumberParts[0]));
        String denominatorRightSide = "1";
        for (int i = 0; i < decimalNumberParts[1].length(); i++) {
            denominatorRightSide += "0";
        }
        Rational rightSideOfDecimal = new Rational(Long.parseLong(decimalNumberParts[1]), Long.parseLong(denominatorRightSide));
        Rational result = leftSideOfDecimal.add(rightSideOfDecimal);
        return (isNegative ? "-" : "") + result.toString();

    }
}
