package ch_13.exercise13_19;

import java.math.BigInteger;

/**
 * 13.15 (Use BigInteger for the RationalNumCalculator class) Redesign and implement the
 * RationalNumCalculator class in Listing 13.13 using BigInteger for the numerator and
 * denominator.
 */
public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /**
     * Construct a rational with default properties
     */
    public Rational() {
        this(0, 1);
    }
    /**
     * Construct a rational with default property of 1 for denominator
     */
    public Rational(long numerator) {
        this(numerator, 1);
    }


    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(long numerator, long denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = BigInteger.valueOf(((denominator > 0) ? 1 : -1) * numerator).divide(gcd);
        this.denominator = BigInteger.valueOf(Math.abs(denominator)).divide(gcd);
    }

    /**
     * Find GCD of two numbers
     *
     * @return BigInteger value of gcd
     */
    private static BigInteger gcd(long n, long d) {
        BigInteger b1 = BigInteger.valueOf(n);
        BigInteger b2 = BigInteger.valueOf(d);
        return b1.gcd(b2);
    }

    /**
     * Return numerator
     */
    public long getNumerator() {
        return numerator.longValue();
    }

    /**
     * Return denominator
     */
    public long getDenominator() {
        return denominator.longValue();
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational) {
        long n = numerator.longValue() * secondRational.getDenominator() +
                denominator.longValue() * secondRational.getNumerator();
        long d = denominator.longValue() * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
        long n = numerator.longValue() * secondRational.getDenominator()
                - denominator.longValue() * secondRational.getNumerator();
        long d = denominator.longValue() * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number by this rational
     */
    public Rational multiply(Rational secondRational) {
        long n = numerator.longValue() * secondRational.getNumerator();
        long d = denominator.longValue() * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Divide a rational number by this rational
     */
    public Rational divide(Rational secondRational) {
        long n = numerator.longValue() * secondRational.getDenominator();
        long d = denominator.longValue() * secondRational.numerator.longValue();
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.intValue() == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational) (other))).getNumerator() == 0)
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.longValue() * 1.0 / denominator.longValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator() > 0)
            return 1;
        else if (this.subtract(o).getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}