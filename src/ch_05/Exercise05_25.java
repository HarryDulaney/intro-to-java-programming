package ch_05;

import java.util.*;

/**
 * **5.25 (Compute p) You can approximate pi by using the following series:
 * pi = 4¢1 - 1 3 + 15 - 1 7 + 1 9 - 11 1 + g + (2-i 1) -i +11 ≤
 * Write a program that displays the p value for i = 10000, 20000, …, and
 * 100000.
 */
public class Exercise05_25 {
    public static void main(String[] args) {

        double pi = 1.0;
        for (int i = 2; i <= 100000; i++) {

            pi += Math.pow(-1, i + 1) / (2 * i - 1.0d);
            if (i % 10000 == 0) {
                System.out.println("For value of i = " + i + " -> PI =  " + (4.0 * pi));
            }
        }
    }
}