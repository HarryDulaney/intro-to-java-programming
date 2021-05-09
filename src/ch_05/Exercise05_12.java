package ch_05;

import java.util.*;

/**
 * 5.12 (Find the smallest n such that n2 > 12,000) Use a while loop to find the smallest
 * integer n such that n2 is greater than 12,000.
 */
public class Exercise05_12 {
    public static void main(String[] args) {
        int i = 1;
        int n = 0;
        double checkInt = 0;
        while ((checkInt = Math.pow(i, 2)) < 12000) {
            n = i;
            i++;
        }
        System.out.println("The smallest integer for n, where n squared is greater than 12,000 is " + n + ". Because " + n + " squared = " + checkInt);
        System.out.println("And " + (n - 1) + " squared = " + Math.pow(n - 1, 2));
    }
}