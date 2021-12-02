package ch_06;

import java.util.Scanner;

/**
 * 6.4 (Display an integer reversed) Write a method with the following header to
 * display an integer in reverse order.  public static void reverse(int number)
 * For example, reverse(3456) displays 6543. Write a test program that prompts
 * the user to enter an integer and displays its reversal.
 */
public class Exercise06_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter and integer now: ");
        int number = input.nextInt();
        reverse(number);
    }

    public static void reverse(int number) {
        while (number > 0) {
            System.out.print(number % 10);
            number = (number / 10);

        }
    }
}
