package ch_08.exercises;
 

/**
 * *8.30 (Algebra: solve linear equations) Write a method that solves the following
2 * 2 system of linear equations:
a00x + a01y = b0
a10x + a11y = b1
x =
b0a11 - b1a01
a00a11 - a01a10
y =
b1a00 - b0a10
a00a11 - a01a10
The method header is
public static double[] linearEquation(double[][] a, double[] b)
The method returns null if a00a11 - a01a10 is 0. Write a test program that
prompts the user to enter a00, a01, a10, a11, b0, and b1, and displays the result. If
a00a11 - a01a10 is 0, report that “The equation has no solution.” A sample run is
similar to Programming Exercise 3.3.
 * @author Jordo
 *
 */
public class E0830{
     public static void main(String[] args) {
    }
}