package ch_04;

import java.util.*;

/**
 * *4.13 (Vowel or consonant?) Write a program that prompts the user to enter a letter
 * check whether the letter is a vowel or consonant.
 * <p>
 * Here is a sample run:
 * Enter a letter: B
 * B is a consonant
 * Enter a letter grade: a
 * a is a vowel
 * Enter a letter grade: #
 * # is an invalid input
 */
public class Exercise04_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String str = in.next().trim();
        if (str.length() > 1) {
            System.out.println(str + " is invalid input.");
        } else {
            char ch = str.charAt(0);
            if (Character.isLetter(ch)) {
                String s = ch + "";
                String res = "";
                if ("aeiou".contains(s.toLowerCase())) {
                    res += "vowel";
                } else {
                    res += "consonant";
                }

                System.out.println(ch + " is a " + res);

            } else {
                System.out.println(ch + " is invalid input.");
            }
        }
        in.close();
    }
}