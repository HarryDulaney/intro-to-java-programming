package ch_06;

import java.util.Scanner;

/**
 * *6.21 (Phone keypads) The international standard letter/number mapping for telephones
 * is shown in Programming Exercise 4.15. Write a method that returns a number,
 * given an uppercase letter, as follows:
 * int getNumber(char uppercaseLetter)
 * <p>
 * Write a test program that prompts the user to enter a phone number as a string.
 * The input number may contain letters. The program translates a letter (uppercase
 * or lowercase) to a digit and leaves all other characters intact.
 *
 */
public class Exercise06_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Exercise06_21 exercise0621 = new Exercise06_21();
        System.out.print("Enter a phone, containing letters, as a string: ");
        String num = in.next();

        String result = "";
        for (int i = 0; i < num.length(); i++) {
            if (Character.isLetter(num.charAt(i))) {
                result += exercise0621.getNumber(num.charAt(i));
            } else {
                result += String.valueOf(num.charAt(i));
            }
        }
        System.out.println(result);
    }

    int getNumber(char upperCaseLetter) {
        String letter = String.valueOf(upperCaseLetter).toLowerCase();
        if ("abc".contains(letter)) {
            return 1;
        } else if ("def".contains(letter)) {
            return 2;

        } else if ("ghi".contains(letter)) {
            return 3;

        } else if ("jkl".contains(letter)) {
            return 4;

        } else if ("mno".contains(letter)) {
            return 5;

        } else if ("pqr".contains(letter)) {
            return 6;

        } else if ("stu".contains(letter)) {
            return 7;

        } else if ("vwx".contains(letter)) {
            return 8;

        } else if ("yz".contains(letter)) {
            return 9;

        }
        return -1;
    }
}
