package ch_13.exercise13_21;

import java.util.Scanner;

/**
 * 13.21 (Algebra: vertex form equations) The equation of a parabola can be expressed
 * in either standard form (y = ax^2 + bx + c) or vertex form (y = a(x - h)^2 + k).
 * <p>
 * <a href="https://mathbitsnotebook.com/Algebra2/Quadratics/QDVertexForm.html">Learn About Quadratics</a>
 * Write a program that prompts the user to enter a, b, and c as integers in standard
 * form and displays h and k in the vertex form.
 * <p>
 * Here are some sample runs.
 * Enter a, b, c: 1 3 1
 * h is -3/2 k is -5/4
 * Enter a, b, c: 2 3 4
 * h is -3/4 k is 23/8
 * <p>
 * When working with the vertex form of a quadratic function:
 * h = -b/2a and k = f(h) >> [The "a" and "b" referenced here refer to f(x) = ax2 + bx + c.]
 * [f(h) means to plug your answer for h into the original equation for x.]
 * Therefore, f(h) = ah^2 + bh + c
 */
public class Exercise13_21 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter a, b, c (as integers): ");
            /* a,b,c as integers in Standard Form */
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            Rational aRational = new Rational(a); // Constructs Rational with denominator of 1 as default
            Rational bRational = new Rational(b); // Constructs Rational with denominator of 1 as default
            Rational cRational = new Rational(c); // Constructs Rational with denominator of 1 as default
            Rational h = new Rational(bRational.multiply(new Rational(-1)).longValue(),
                    aRational.multiply(new Rational(2)).longValue());
            Rational k = aRational.multiply(h.multiply(h)).add(bRational.multiply(h)).add(cRational);
            System.out.println("h is " + h + ", k is " + k);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
