package ch_05;

import java.util.*;

/**
 * *5.42 (Financial application: find the sales amount) Rewrite Programming Exercise
 * 5.39 as follows:
 * ■ Use a for loop instead of a do-while loop.
 * ■ Let the user enter COMMISSION_SOUGHT instead of fixing it as a constant.
 */
public class Exercise05_42 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double comish = 0;
        double bal = 0;
        double sales = 0;

        System.out.println("Enter the commission desired: ");
        double potentialComish = in.nextDouble();

        for (sales = 0.01; comish < potentialComish; sales += 0.01) {
            bal = comish = 0.0;

            if (sales >= 10000.01)
                comish += (bal = sales - 10000) * 0.12;
            if (sales >= 5000.01)
                comish += (bal -= bal - 5000) * 0.10;

            if (sales >= 0.01)
                comish += bal * 0.08;
        }

        System.out.printf(
                "Sales must be $%.0f to earn commission of $%.0f\n", potentialComish, sales);
    }
}