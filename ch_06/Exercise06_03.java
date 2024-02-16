package ch_06;

import java.util.*;

/**
 * **6.3 (Palindrome integer) Write the methods with the following headers
 * // Return the reversal of an integer, i.e., reverse(456) returns 654
 * public static int reverse(int number)
 * // Return true if number is a palindrome
 * public static boolean isPalindrome(int number)
 * Use the reverse method to implement isPalindrome.
 * A number is a palindrome if its reversal is the same as itself.
 * Write a test program that prompts the
 * user to enter an integer and reports whether the integer is a palindrome.
 */
public class Exercise06_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = in.nextInt();

        if (isPalindrome(num)) {
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Is not a palindrome");
        }
    }

    public static int reverse(int n) {
         int num1 = 0;
       while( n != 0){
           num1 =num1 *10;
          num1 += n % 10 ;
          n = n / 10;
       }
       return num1;
    }

    public static boolean isPalindrome(int number) {
        String n1 = String.valueOf(number);
        String n2 = String.valueOf(reverse(number));

        return n1.equals(n2);

    }
}
