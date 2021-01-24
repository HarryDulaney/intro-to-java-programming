package ch_04;

import java.awt.*;
import java.util.*;

/**
 * *4.15 (Phone key pads) The international standard letter/number mapping found on the
 * telephone is shown below:
 * Write a program that prompts the user to enter a letter and displays its corresponding number.
 * Enter a letter: A
 * The corresponding number is 2
 */
public class Exercise04_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String letter = in.nextLine().trim();
        letter = letter.toLowerCase();

        int num = 0;

        if ("abc".contains(letter)) {
            num = 1;
        } else if ("def".contains(letter)) {
            num = 2;

        } else if ("ghi".contains(letter)) {
            num = 3;

        } else if ("jkl".contains(letter)) {
            num = 4;

        } else if ("mno".contains(letter)) {
            num = 5;

        } else if ("pqr".contains(letter)) {
            num = 6;

        } else if ("stu".contains(letter)) {
            num = 7;

        } else if ("vwx".contains(letter)) {
            num = 8;

        } else if ("yz".contains(letter)) {
            num = 9;

        } else {
            System.out.println("Invalid character entered.");
            System.exit(0);
        }

        System.out.println("The corresponding key is: " + num);
    }
}