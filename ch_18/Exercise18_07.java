package ch_18;

import java.util.Scanner;

/**
 * *18.7 (Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java,
 * so that the program finds the number of times the fib method is called.
 * <p>
 * (Hint: Use a static variable and increment it every time the method is called.)
 *
 */
public class Exercise18_07 {
    static int fibCalls = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an index in the Fibonacci sequence: ");
        long targetIndex = in.nextInt();


        System.out.println("Fibonacci num at " + targetIndex + " is " + fib(targetIndex));
        System.out.println("Fib method called " + fibCalls + " times.");
        in.close();

    }

    static long fib(long n) {
        if (n <= 1) {
            return n;
        }
        ++fibCalls;
        return fib(n - 1) + fib(n - 2);
    }

}
