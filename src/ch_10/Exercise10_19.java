package ch_10;

import java.math.BigInteger;

/**
 * 10.19 (Mersenne prime) A prime number is called a Mersenne prime if it can be written in the form 2^p - 1 for some
 * positive integer p. Write a program that finds
 * all Mersenne primes with p … 100 and displays the output as shown below.
 * (Hint: You have to use BigInteger to store the number, because it is too big to
 * be stored in long. Your program may take several hours to run.)
 */
public class Exercise10_19 {
    static int P = 2;
    static BigInteger TWO = BigInteger.valueOf(2L);

    public static void main(String[] args) {
        System.out.print("p     2^p - 1");

        while (P <= 100) {
            BigInteger mersennePrime = TWO.pow(P).subtract(BigInteger.ONE);
            if (mersennePrime.isProbablePrime(1)) {
                System.out.print("\n" + P + "     " + mersennePrime.toString());
                System.out.println();
                P++;
            }
        }
    }

}

