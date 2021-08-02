package ch_13.exercise13_14;

/**
 * 13.14 (Demonstrate the benefits of encapsulation) Rewrite the RationalNumCalculator class in
 * Listing 13.13 using a new internal representation for the numerator and denominator.
 * Create an array of two integers as follows:
 * private long[] r = new long[2];
 * Use r[0] to represent the numerator and r[1] to represent the denominator.
 * The signatures of the methods in the RationalNumCalculator class are not changed, so a client
 * application that uses the previous RationalNumCalculator class can continue to use this new
 * RationalNumCalculator class without being recompiled.
 */
public class Exercise13_14 {
    /* Test from the book but using the new RationalNumCalculator number class */
    public static void main(String[] args) {
        System.out.println("Using the RationalNumCalculator class..");
        Rational r1 = new Rational(1, 123456789);
        Rational r2 = new Rational(1, 123456789);
        Rational r3 = new Rational(1, 123456789);
        System.out.println("r1 * r2 * r3 is " +
                r1.multiply(r2.multiply(r3)));
    }
}


