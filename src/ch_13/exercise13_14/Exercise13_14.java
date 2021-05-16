package ch_13.exercise13_14;

/**
 * 13.14 (Demonstrate the benefits of encapsulation) Rewrite the Rational class in
 * Listing 13.13 using a new internal representation for the numerator and denominator.
 * Create an array of two integers as follows:
 * private long[] r = new long[2];
 * Use r[0] to represent the numerator and r[1] to represent the denominator.
 * The signatures of the methods in the Rational class are not changed, so a client
 * application that uses the previous Rational class can continue to use this new
 * Rational class without being recompiled.
 */
public class Exercise13_14 {
   static Rational rational = new Rational();

    public static void main(String[] args) {
        System.out.println("Using the Rational class..");
        System.out.println(rational.toString());
    }
}


