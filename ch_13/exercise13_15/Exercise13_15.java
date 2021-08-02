package ch_13.exercise13_15;

/**
 * 13.15 (Use BigInteger for the RationalNumCalculator class) Redesign and implement the
 * RationalNumCalculator class in Listing 13.13 using BigInteger for the numerator and
 * denominator.
 */
public class Exercise13_15 {
    public static void main(String[] args) {
        //Test behavior of RationalNumCalculator number class that uses BigInteger internally
        System.out.println("Using the RationalNumCalculator class..");
        ch_13.exercise13_15.Rational r1 = new ch_13.exercise13_15.Rational(1, 123456789);
        ch_13.exercise13_15.Rational r2 = new ch_13.exercise13_15.Rational(1, 123456789);
        ch_13.exercise13_15.Rational r3 = new ch_13.exercise13_15.Rational(1, 123456789);
        System.out.println("r1 * r2 * r3 is " +
                r1.multiply(r2.multiply(r3)));
    }
}
