package ch_18;

import java.util.Scanner;

/**
 * *18.2 (Fibonacci numbers) Rewrite the fib method in Listing 18.2 using iterations.
 * Hint: To compute fib(n) without recursion, you need to obtain fib(n - 2)
 * and fib(n - 1) first. Let f0 and f1 denote the two previous Fibonacci
 * numbers. The current Fibonacci number would then be f0 + f1.
 * <p>
 * The algorithm can be described as follows:
 * f0 = 0; // For fib(0)
 * f1 = 1; // For fib(1)
 * for (int i = 1; i <= n; i++) {
 * currentFib = f0 + f1;
 * f0 = f1;
 * f1 = currentFib;
 * }
 * // After the loop, currentFib is fib(n)
 * Write a test program that prompts the user to enter an index and displays its
 * <p>
 * <p>
 * Listing 18.2:
 * <p>
 * <p>
 * {@code import java.util.Scanner;
 * public class ComputeFibonacci {
 * Main method *
 * public static void main(String[]args){
 * Scanner input=new Scanner(System.in);
 * System.out.print("Enter an index for a Fibonacci number: ");
 * int index=input.nextInt();
 * System.out.println("The Fibonacci number at index "
 * +index+" is "+fib(index));
 * }
 * The method for finding the Fibonacci number
 * public static long fib(long index){
 * if(index==0)
 * return 0;
 * else if (index == 1) // Base case
 * return 1;
 * else // Reduction and recursive calls
 * return fib(index - 1) + fib(index - 2);
 * }}
 */
public class Exercise18_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an index in the Fibonacci sequence: ");
        int idx = in.nextInt();

        System.out.println("Fibonacci num at " + idx + " is " + fib(idx));
        in.close();
    }

    static long fib(int idx) {
        long f0 = 0;
        long f1 = 1;
        long result = 0;
        for (int i = 1; i < idx; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }


}
