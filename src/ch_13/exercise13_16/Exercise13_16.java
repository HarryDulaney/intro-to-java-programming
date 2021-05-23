package ch_13.exercise13_16;

import java.util.Map;
import java.util.Set;

/**
 * 13.16 (Create a rational-number calculator) Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10a.
 * You will need to use the split method in the String class, introduced in
 * Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string and
 * denominator string, and convert strings into integers using the Integer.parseInt
 * method.
 */
public class Exercise13_16 {
    public static void main(String[] args) {
        System.out.println("See RationalNumCalculator.java....");
        System.out.println("javac RationalNumCalculator.java");
        System.out.print("Usage: java RationalNumCalculator \"11/453 +-*/ 7/44\" ");
        System.out.print(" or: java RationalNumCalculator \"112 +-*/ 9/17\" ");
    }
}
