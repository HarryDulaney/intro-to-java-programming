package ch_06;

import java.util.*;

/**
 * **6.31 (Financial: credit card number validation) Credit card numbers follow certain patterns.
 * A credit card number must have between 13 and 16 digits. It must start with:
 * ■ 4 for Visa cards
 * ■ 5 for Master cards
 * ■ 37 for American Express cards
 * ■ 6 for Discover cards
 * <p>
 * In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card
 * numbers. The algorithm is useful to determine whether a card number is entered
 * correctly or whether a credit card is scanned correctly by a scanner. Credit card
 * numbers are generated following this validity check, commonly known as the
 * Luhn check or the Mod 10 check, which can be described as follows (for illustration, consider the card number 4388576018402626):
 * <p>
 * 1. Double every second digit from right to left. If doubling of a digit results in a
 * two-digit number, add up the two digits to get a single-digit number.
 * 4388576018402626
 * 2 * 2 = 4
 * 2 * 2 = 4
 * 4 * 2 = 8
 * 1 * 2 = 2
 * 6 * 2 = 12 (1 + 2 = 3)
 * 5 * 2 = 10 (1 + 0 = 1)
 * 8 * 2 = 16 (1 + 6 = 7)
 * 4 * 2 = 8
 * <p>
 * 2. Now add all single-digit numbers from Step 1.
 * 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
 * 3. Add all digits in the odd places from right to left in the card number.
 * 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
 * 4. Sum the results from Step 2 and Step 3.
 * 37 + 38 = 75
 * 5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise,
 * it is invalid. For example, the number 4388576018402626 is invalid, but the
 * number 4388576018410707 is valid.
 * Write a program that prompts the user to enter a credit card number as a long
 * integer. Display whether the number is valid or invalid. Design your program to
 * use the following methods:
 * <p>
 * // Return true if the card number is valid //
 * public static boolean isValid(long number)
 * <p>
 * // Get the result from Step 2 //
 * public static int sumOfDoubleEvenPlace(long number)
 * <p>
 * // Return this number if it is a single digit, otherwise,
 * return the sum of the two digits //
 * public static int getDigit(int number)
 * <p>
 * // Return sum of odd-place digits in number //
 * public static int sumOfOddPlace(long number)
 * <p>
 * // Return true if the digit d is a prefix for number //
 * public static boolean prefixMatched(long number,int d)
 * <p>
 * // Return the number of digits in d //
 * public static int getSize(long d)
 * <p>
 * // Return the first k number of digits from number. If the
 * * number of digits in number is less than k, return number. //
 * public static long getPrefix(long number,int k)
 * <p>
 * Here are sample runs of the program:(You may also implement this program by
 * reading the input as a string and processing the string to validate the credit card.)
 * Enter a credit card number as a long integer:
 * 4388576018410707
 * 4388576018410707is valid
 * Enter a credit card number as a long integer:
 * 4388576018402626
 * 4388576018402626 is invalid
 *
 * @author Harry D.
 */
public class Exercise06_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer: ");
        String ccNum = in.next();

        System.out.println(ccNum + (isValid(Long.parseLong(ccNum)) ? " is valid." : " is invalid."));
    }

    /**
     * Return true if the card number is valid
     */
    public static boolean isValid(long number) {
        String s = String.valueOf(number);
        if (s.length() < 13 || s.length() > 16) {
            return false;
        } else if (prefixMatched(number, 4) || prefixMatched(number, 6) || prefixMatched(number, 5) || prefixMatched(number, 37)) {
            int sumEven = sumOfDoubleEvenPlace(number);
            int sumOdd = sumOfOddPlace(number);
            int total = sumEven + sumOdd;
            return total % 10 == 0;
        }
        return false;
    }

    /**
     * Get the result from Step 2
     */
    public static int sumOfDoubleEvenPlace(long number) {
        System.out.println("Sum of Double Even Place Numbers: ");
        int sum = 0;
        String n = String.valueOf(number);
        for (int i = n.length() - 2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(n.substring(i, i + 1));
            System.out.println("extracted digit:" + digit);
            int temp = digit + digit;
            int d = getDigit(temp);
            System.out.println("Digit processed into: " + d);
            sum += d;
        }
        return sum;
    }

    /**
     * Return this number if it is a single digit, otherwise,
     * return the sum of the two digits
     */
    public static int getDigit(int number) {
        if (getSize(number) > 1) {
            int d1 = number % 10;
            int d2 = number / 10;
            return d1 + d2;
        }
        return number;
    }

    /**
     * Return sum of odd-place digits in number
     */
    public static int sumOfOddPlace(long number) {
        System.out.println("Sum of Odd Place Numbers: ");
        int sum = 0;
        String n = String.valueOf(number);
        for (int i = n.length() - 1; i >= 0; i -= 2) {
            int x = Integer.parseInt(n.substring(i, i + 1));
            System.out.println("Extracted digit " + x);
            sum += x;
        }
        return sum;
    }

    /**
     * Return true if the digit d is a prefix for number
     */
    public static boolean prefixMatched(long number, int d) {
        String s = String.valueOf(number);
        if (s.startsWith(String.valueOf(d))) {
            return true;
        }
        return false;
    }

    /**
     * Return the number of digits in d
     */
    public static int getSize(long d) {
        String s = String.valueOf(d);
        return s.length();
    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {
        if (getSize(number) < k) {
            return number;
        }
        String s = String.valueOf(number);
        return Long.parseLong(s.substring(0, k));
    }
}