package ch_04;

import java.util.Scanner;

/**
 * Enter string s1: ABCD
 * Enter string s2: BC
 * BC is a substring of ABCD
 * 4.22 (Check substring) Write a program that prompts the user to enter two strings and
 * reports whether the second string is a substring of the first string.
 */
public class Exercise04_22 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter string s1: ");

        String s1 = in.next();
        System.out.print("Enter string s2: ");
        String s2 = in.next();

        int longestLength = Math.max(s1.length(), s2.length());
        final String IS_A = " is a";
        final String IS_NOT = " is not a";
        String big, small;

        if (longestLength == s1.length()) {
            big = s1;
            small = s2;

        } else {
            big = s2;
            small = s1;
        }
        String result = "";
        if (big.contains(small)) {
            result += IS_A;
        } else {
            result += IS_NOT;
        }


        System.out.print(small + result + " substring " + big);
        in.close();
    }
}