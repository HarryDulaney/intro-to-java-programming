package ch_06;

import java.util.Scanner;

/**
 * **6.18 (Check password) Some websites impose certain rules for passwords. Write a
 * method that checks whether a string is a valid password. Suppose the password
 * rules are as follows:
 * ■ A password must have at least eight characters.
 * ■ A password consists of only letters and digits.
 * ■ A password must contain at least two digits.
 * Write a program that prompts the user to enter a password and displays Valid
 * Password if the rules are followed or Invalid Password otherwise\
 *
 * @author Harry D.
 */
public class Exercise06_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the password to check: ");
        String pwd = in.next();
        System.out.println(validatePassword(pwd) ? "Valid Password" : "Invalid Password");

        in.close();
    }

    static boolean validatePassword(String pword) {
        int countDigits = 0;
        if (pword.length() < 8) {
            return false;
        }
        for (int i = 0; i < pword.length(); i++) {
            char c = pword.charAt(i);
            if (Character.isDigit(c)) {
                countDigits++;
            } else if (!Character.isLetter(c)) {
                return false; // Not a digit or a letter
            }
        }
        return countDigits >= 2;
    }
}

