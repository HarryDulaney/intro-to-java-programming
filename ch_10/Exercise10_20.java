package ch_10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * 10.20 (Approximate e) Programming Exercise 5.26 approximates e using the following
 * series:
 * In order to get better precision, use BigDecimal with 25 digits of precision in
 * the computation. Write a program that displays the e value for i = 100, 200, . . .,
 * and 1000.
 */
public class Exercise10_20 {
    public static void main(String[] args) {
        BigDecimal E = BigDecimal.valueOf(1.0);
        for (int i = 100; i <= 1000; i++) {
            BigDecimal numerator = BigDecimal.valueOf(1.0);
            BigDecimal denominator = new BigDecimal(factorial(i));
            BigDecimal result = numerator.divide(denominator, 25, BigDecimal.ROUND_UP);
            E = E.add(result);
            if (i % 100 == 0)
                System.out.println(E);

        }

    }

    public static BigInteger factorial(int x) {
        BigInteger temp = new BigInteger("1");
        for (int i = 1; i <= x; i++)
            temp = temp.multiply(BigInteger.valueOf(i));
        return temp;
    }
}

