package ch_13.exercise13_16;

import ch_13.exercise13_15.Rational;

/**
 * 13.16 (Create a rational-number calculator) Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10a.
 * You will need to use the split method in the String class, introduced in
 * Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string and
 * denominator string, and convert strings into integers using the Integer.parseInt
 * method.
 * <p>
 * Usage: java RationalNumCalculator "1/5 * 7/8"
 */
public class RationalNumCalculator {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println(
                    "Usage: java RNumCalculator \"operand1 operator operand2\" ");
            System.exit(0);
        }
        if (args[0].contains("/") || args[2].contains("/")) {
            Rational r1 = new Rational();
            if (args[0].contains("/")) {
                String[] operand1 = args[0].split("/");
                long n = Long.parseLong(operand1[0]);
                long d = Long.parseLong(operand1[1]);
                r1 = new Rational(n, d);
            } else { //Not a rational number
                r1 = new Rational(Long.parseLong(args[0]), 1); // args[0] is not a rational number. So set to number_value(args[0]) / 1
            }
            Rational r2 = new Rational();
            if (args[2].contains("/")) {
                String[] o2 = args[2].split("/");
                long n2 = Long.parseLong(o2[0]);
                long d2 = Long.parseLong(o2[1]);
                r2 = new Rational(n2, d2);
            } else {
                r2 = new Rational(Long.parseLong(args[2]), 1);
            }
            Rational result = new Rational();
            switch (args[1].charAt(0)) {
                case '+':
                    result = r1.add(r2);
                    break;
                case '-':
                    result = r1.subtract(r2);
                    break;
                case '.':
                    result = r1.multiply(r2);
                    break;
                case '/':
                    result = r1.divide(r2);
            }
            System.out.println("Rational Number calculator result: " + result.intValue());

        } else {
            int result = 0;
            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) +
                            Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0]) -
                            Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) *
                            Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) /
                            Integer.parseInt(args[2]);
            }
            System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                    + " = " + result);
        }
    }
}
