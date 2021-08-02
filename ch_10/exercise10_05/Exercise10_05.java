package ch_10.exercise10_05;

import java.util.Scanner;

/**
 * *10.5 (Displaying the prime factors) Write a program that prompts the user to enter
 * a positive integer and displays all its smallest factors in decreasing order.
 * <p>
 * For example, if the integer is 120, the smallest factors are displayed as 5, 3, 2, 2,
 * 2.
 * <p>
 * **** Use the StackOfIntegers class to store the factors (e.g., 2, 2, 2, 3, 5) and
 * retrieve and display them in reverse order. ******
 */
public class Exercise10_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(" Enter a positive integer to find its smallest factors: ");
        int n = in.nextInt();
        StackOfIntegers soi = new StackOfIntegers();
        StackOfIntegers revStack = new StackOfIntegers();
        for (int f = 2; n != 1; f++) {
            if (n % f == 0) {
                soi.push(f);
                n /= f;
                f = 1; // Reset the test factor
            }
        }

        while (!soi.empty()) {
            revStack.push(soi.pop());
        }
        while (revStack.getSize() > 1) {
            System.out.print(revStack.pop() + ", ");
        }
        System.out.print(revStack.pop()); //Print last number w/o a comma

        in.close();

    }

}
