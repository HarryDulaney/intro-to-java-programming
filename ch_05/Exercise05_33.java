package ch_05;

import java.util.*;

/**
 * **5.33 (Perfect number) A positive integer is called a perfect number if it is equal to
 * the sum of all of its positive divisors, excluding itself. For example, 6 is the first
 * perfect number because 6 = 3 + 2 + 1. The next is 28 = 14 + 7 + 4 + 2
 * + 1. There are four perfect numbers less than 10,000. Write a program to find all
 * these four numbers
 */
public class Exercise05_33 {
    public static void main(String[] args) {
        for (int number = 6; number <= 10000; number++) {
            int total = 0;
            int divisor = number - 1;

            while (divisor > 0) {

                if (number % divisor == 0) {
                    total += divisor;
                }
                divisor--;
            }

            if (number == total) {
                System.out.println(number);
            }

        }
    }
}