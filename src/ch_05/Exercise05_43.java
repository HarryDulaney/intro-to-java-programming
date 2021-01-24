package ch_05;

import java.util.*;

/**
 * *5.43 (Math: combinations) Write a program that displays all possible combinations
 * for picking two numbers from integers 1 to 7. Also display the total number of
 * all combinations.
 */
public class Exercise05_43 {
    public static void main(String[] args) {

        int count = 0;
        for (int n = 1; n < 7; n++) {
            for (int j = n + 1; j <= 7; j++) {
                System.out.println(n + " " + j);
                count++;
            }
        }
        System.out.println("Total combinations -> " + count);
    }
}