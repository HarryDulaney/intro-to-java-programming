package ch_05;

import java.util.*;

/**
 * *5.49 (Count vowels and consonants) Assume letters A, E, I, O, and U as the vowels.
 * Write a program that prompts the user to enter a string and displays the number
 * of vowels and consonants in the string.
 * <p>
 * Enter a string: Programming is fun
 * * The number of vowels is 5
 * * The number of consonants is 11
 */
public class Exercise05_49 {
    public static void main(String[] args) {
        final String vowelString = "AEIOU";

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = in.nextLine().toUpperCase();
        int vowels = 0, consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (vowelString.contains(String.valueOf(ch))) {
                    ++vowels;
                } else {
                    ++consonants;
                }
            }
        }
        in.close();
        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);
    }
}