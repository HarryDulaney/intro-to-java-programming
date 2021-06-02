package ch_13.exercise13_18;

import ch_13.exercise13_15.Rational;

/**
 * 13.18 (Use the Rational class) Write a program that computes the following summation series using the Rational class:
 * 1/2 + 2/3 + 3/4 + ... + 98/99 + 99/100
 * You will discover that the output is incorrect because of integer overflow (too
 * large).
 * <p>
 * To fix this problem, see Programming Exercise 13.15.
 */
public class Exercise13_18 {
    public static void main(String[] args) {
        Rational resultRational = new Rational();
        long i = 2;
        while (i <= 100) {
            Rational rational = new Rational(i - 1, i);
            System.out.print(rational.getNumerator() + "/" + rational.getDenominator());

            if (i == 100) System.out.print(" = ");
            else if (i % 10 == 0) System.out.println(" + ");
            else System.out.print(" + ");

            resultRational = resultRational.add(rational);
            i++;
        }
        System.out.println(resultRational.getNumerator() + " / " + resultRational.getDenominator());

    }
}
