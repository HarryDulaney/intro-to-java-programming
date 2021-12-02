package ch_06;

/**
 * 6.11 (Financial application: compute commissions) Write a method that computes the
 * commission, using the scheme in Programming Exercise 5.39.
 * <p><br>
 * {@code 5.39 (Financial application: find the sales amount) You have just started a sales job
 * in a department store. Your pay consists of a base salary and a commission. The
 * base salary is $5,000. The scheme shown below is used to determine the commission rate.
 * <p>
 * Sales Amount --------- Commission Rate
 * <p>
 * $0.01–$5,000 --------------- 8 percent
 * <p>
 * $5,000.01–$10,000 ---------- 10 percent
 * <p>
 * $10,000.01 and above ------- 12 percent
 * <p>
 * <p>
 * Note that this is a graduated rate. The rate for the first $5,000 is at 8%, the next
 * $5000 is at 10%, and the rest is at 12%. If the sales amount is 25,000, the commission is 5,000 * 8% + 5,000 * 10% + 15,000 * 12% = 2,700.
 * <p><br>}
 * <p>
 * <p>
 * The header of the
 * method is as follows:
 * public static double computeCommission(double salesAmount)
 * <p>
 * Write a test program that displays the following table:
 * Sales Amount Commission
 * 10000 900.0
 * 15000 1500.0
 * ...
 * 95000 11100.0
 * 100000 11700.0
 */
public class Exercise06_11 {
    public static void main(String[] args) {
        System.out.println("Sales  Commission Amount");
        for (int sales = 10000; sales <= 100000; sales += 5000) {
            System.out.print(sales);
            System.out.print("   ");
            System.out.printf("%.1f\n", computeCommission(sales));
        }

    }

    public static double computeCommission(double salesAmount) {
        double commission = 0;
        if (salesAmount <= 5000) {
            commission = salesAmount * 0.08;

        } else if (salesAmount <= 10000) {
            salesAmount -= 5000;
            commission = (5000 * 0.08) + (salesAmount * .10);

        } else if (salesAmount > 10000) {
            commission = (5000 * 0.08);
            salesAmount -= 5000;

            commission += (5000 * .10);
            salesAmount -= 5000;

            commission += salesAmount * .12;
        }
        return commission;
    }
}