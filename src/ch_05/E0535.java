package ch_05;

import java.util.*;

/**
 * *5.35 (Summation) Write a program to compute the following summation.
 */
public class E0535 {
    public static void main(String[] args) {

        double result = 1 / (1 + Math.sqrt(2));
        for (int i = 2; i < 625; i++) {

            result += 1 / (Math.sqrt(i) + Math.sqrt(i + 1));

        }
        System.out.println(result);
    }
}