package ch_13.exercise13_20;

/**
 * 13.17 (Math: The Complex class) A complex number is a number in the form a + bi,
 * -where a and b are real numbers and i is SQRT(-1). The numbers a and b are known
 * as the real part and imaginary part of the complex number, respectively. You can
 * perform addition, subtraction, multiplication, and division for complex numbers
 * using the following formulas:
 * a + bi + c + di = (a + c) + (b + d)i
 * a + bi - (c + di) = (a - c) + (b - d)i
 * (a + bi)*(c + di) = (ac - bd) + (bc + ad)i
 * (a + bi)/(c + di) = (ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)
 * <p>
 * You can also obtain the absolute value for a complex number using the following
 * formula:
 * |a + bi|  = SQRT(a2 + b2)
 * (A complex number can be interpreted as a point on a plane by identifying the (a,b)
 * values as the coordinates of the point. The absolute value of the complex number
 * corresponds to the distance of the point to the origin, as shown in Figure 13.10b.)
 * <p>
 * Design a class named Complex for representing complex numbers and the
 * methods add, subtract, multiply, divide, and abs for performing complex number operations,
 * and override toString method for returning a string representation for a complex number.
 * The toString method returns (a + bi) as a string. If b is 0, it simply returns a.
 * Your Complex class should also implement the Cloneable interface.
 * <p>
 * Provide three constructors Complex(a, b), Complex(a), and Complex().
 * Complex() creates a Complex object for number 0 and Complex(a) creates a Complex object with 0 for b.
 * Also provide the getRealPart() and getImaginaryPart() methods for returning the real and imaginary part
 * of the complex number, respectively.
 */
public class Complex extends Number implements Cloneable {

    private double a;
    private double b;
    private static double i = Math.sqrt(-1);

    public Complex() {
        this(0);
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Example addition:  (a + bi) + (c + di) = (a + c) + (b + d)i
     *
     * @param complex Complex number to add
     * @return the addition result
     */
    public double add(Complex complex) {
        return (this.a + complex.a) + (this.b + complex.b) * i;
    }

    /**
     * Subtract example:
     * a + bi - (c + di) = (a - c) + (b - d)i
     *
     * @param complex
     * @return
     */
    public double subtract(Complex complex) {
        return (this.a - complex.a) + (this.b - complex.b) * i;

    }

    /**
     * (a + bi)*(c + di) = (ac - bd) + (bc + ad)i
     *
     * @param complex
     * @return
     */
    public double multiply(Complex complex) {
        return (this.a * complex.a - this.b * complex.b) + ((this.b * complex.a + this.a * complex.b) * i);
    }

    /**
     * (a + bi)/(c + di) = (ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)
     *
     * @param complex
     * @return
     */
    public double divide(Complex complex) {
        return (this.a * complex.a + this.b * complex.b) / (Math.pow(complex.a, 2) + Math.pow(complex.b, 2)) + ((this.b * complex.a - this.a * complex.b) * i) / (Math.pow(complex.a, 2) + Math.pow(complex.b, 2));
    }

    public double abs(Complex complex) {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b * i;
    }

    @Override
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();

    }

    @Override
    public int intValue() {
        return (int) Math.round(a + b * i);
    }

    @Override
    public long longValue() {
        return Math.round(a + b * i);
    }

    @Override
    public float floatValue() {
        return (float) (a + b * i);
    }

    @Override
    public double doubleValue() {
        return a + b * i;
    }

    @Override
    public String toString() {
        if (b == 0)
            return String.format("%2.1f", a);
        else
            return String.format("%2.1f + %2.4fi", a, b);
    }

}
