package ch_05;

import java.util.*;

/**
 * 5.13 (Find the largest n such that n^3 < 12,000) Use a while loop to find the largest
 * integer n such that n3 is less than 12,000.
 */
public class Exercise05_13 {
    public static void main(String[] args) {

        int n = 1;
        while (Math.pow(n, 3) < 12000) {
            if (Math.pow(n + 1, 3) > 12000) {
                break;
            } else {
                n++;
            }
        }
        System.out.println(n + " * " + n + " * " + n + " = " + (int) Math.pow(n, 3));

    }
}