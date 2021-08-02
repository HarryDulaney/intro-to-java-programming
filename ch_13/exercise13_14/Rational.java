package ch_13.exercise13_14;

/**
 * 13.14 (Demonstrate the benefits of encapsulation) Rewrite the RationalNumCalculator class in
 * Listing 13.13 using a new internal representation for the numerator and denominator.
 * Create an array of two integers as follows:
 * private long[] r = new long[2];
 * Use r[0] to represent the numerator and r[1] to represent the denominator.
 * The signatures of the methods in the RationalNumCalculator class are not changed, so a client
 * application that uses the previous RationalNumCalculator class can continue to use this new
 * <p>
 * RationalNumCalculator class without being recompiled.
 */
public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator = r[0],  and denominator = r[1]
    private long[] r = new long[2];


    /**
     * Construct a rational with default properties
     */
    public Rational() {
        this(0, 1);
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        long n = ((denominator > 0) ? 1 : -1) * numerator / gcd;
        long d = Math.abs(denominator) / gcd;
        r[0] = n;
        r[1] = d;
    }

    /**
     * Find GCD of two numbers
     */
    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;
        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }
        return gcd;

    }

    /**
     * Return numerator
     */
    public long getNumerator() {
        return r[0];
    }

    /**
     * Return denominator
     */
    public long getDenominator() {
        return r[1];
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational) {
        long n = r[0] * secondRational.getDenominator() +
                r[1] * secondRational.getNumerator();
        long d = r[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
        long n = r[0] * secondRational.getDenominator()
                - r[1] * secondRational.getNumerator();
        long d = r[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number by this rational
     */
    public Rational multiply(Rational secondRational) {
        long n = r[0] * secondRational.getNumerator();
        long d = r[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Divide a rational number by this rational
     */
    public Rational divide(Rational secondRational) {
        long n = r[0] * secondRational.getDenominator();
        long d = r[1] * secondRational.getNumerator();
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (r[1] == 1)
            return r[0] + "";
        else
            return r[0] + "/" + r[1];
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
        return r[0] * 1.0 / r[1];
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