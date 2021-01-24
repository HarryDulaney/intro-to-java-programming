package ch_05;

import java.util.*;

/**
 * 5.39 (Financial application: find the sales amount) You have just started a sales job
 * in a department store. Your pay consists of a base salary and a commission. The
 * base salary is $5,000. The scheme shown below is used to determine the commission rate.
 * <p>
 * <p>
 * Sales Amount --------- Commission Rate
 * <hr>
 * $0.01–$5,000 --------------- 8 percent
 * <hr>
 * $5,000.01–$10,000 ---------- 10 percent
 * <hr>
 * $10,000.01 and above ------- 12 percent
 * <p>
 * <p>
 * Note that this is a graduated rate. The rate for the first $5,000 is at 8%, the next
 * $5000 is at 10%, and the rest is at 12%. If the sales amount is 25,000, the commission is 5,000 * 8% + 5,000 * 10% + 15,000 * 12% = 2,700.
 * <p>
 * Your goal is to earn $30,000 a year. Write a program that finds the minimum sales
 * you have to generate in order to make $30,000.
 */
public class Exercise05_39 {
    public static void main(String[] args) {
        final double TARGET = 30000;
        double actual = 0;
        double bal = 0;
        double sales = 0;
        do {
            bal = actual = 0;
            sales += 0.01;

            if (sales > 10000)
                actual += (bal = sales - 10000) * 0.12;

            if (sales > 5000)
                actual += (bal -= bal - 5000) * 0.10;

            if (sales > 0)
                actual += bal * 0.08;

        } while (actual < TARGET);

        System.out.printf("Sales required to earn $30,000 of commission is $%.2f\n", sales);
    }
}