package ch_05;

import java.util.*;

/**
 * **5.26 (Compute e) You can approximate e using the following series:
 * e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ... + 1/i!
 * Write a program that displays the e value for i = 10000, 20000, …, and
 * 100000. (Hint: Because i! = i * (i - 1) * c * 2 * 1, then
 * 1 i!
 * is
 * 1
 * i(i - 1)!
 * Initialize e and item to be 1 and keep adding a new item to e. The new item is
 * the previous item divided by i for i = 2, 3, 4, ....)
 */
public class Exercise05_26 {
    static double e;

    public static void main(String[] args) {
        double e = 1;
        int item = 10000;
        while (item <= 100000) {
            double denominator = 0;
            for (double i = 1; i <= item; i++) {
                denominator += i * (i - 1);
            }
            e += 1 / denominator;
            System.out.println("e is " + e + " when i is " + item);
            item += 10000;
        }
    }
}

