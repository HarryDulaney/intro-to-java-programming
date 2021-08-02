package ch_04;

import java.util.*;

/**
 * 4.19 (Business: check ISBN-10) Rewrite the Programming Exercise 3.9 by entering the
 * ISBN number as a string.
 */
public class Exercise04_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        System.out.println("Enter first 9 numbers in ISBN: ");
        String isbn = in.nextLine();
        for (int i = 0, j = 1; i < 9; i++, j++) {
            int num = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            sum += num * j;
        }
        int d10 = sum % 11;
        if (d10 == 10) {
            isbn += "X";
        } else {
            isbn += d10;

        }
        System.out.println("The ISBN-10 is " + isbn);
    }
}