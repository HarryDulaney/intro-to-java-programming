package ch_05;

import java.util.*;

/**
 * *5.23 (Demonstrate cancellation errors) A cancellation error occurs when you are
 * manipulating a very large number with a very small number. The large number
 * may cancel out the smaller number. For example, the result of 100000000.0 +
 * 0.000000001 is equal to 100000000.0. To avoid cancellation errors and obtain
 * more accurate results, carefully select the order of computation.
 * <p>
 * For example, in
 * computing the following series, you will obtain more accurate results by
 * computing from right to left rather than from left to right:
 * 1 +
 * 1 2
 * +
 * 1 3
 * + c +
 * 1 n
 */
public class Exercise05_23 {
    public static void main(String[] args) {
        double checkSum = 0.0;
        for (int i = 1000; i >= 1; i--) {
            checkSum += 1.0 / i;
        }
        System.out.println("Result of computing sum of the series from right to left was " + checkSum);


    }
}