package ch_05;

import java.util.*;

/**
 * **5.38 (Decimal to octal) Write a program that prompts the user to enter a decimal
 * integer and displays its corresponding octal value. Don’t use Java’s Integer
 * .toOctalString(int) in this program.
 */
public class Exercise05_38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a decimal integer: ");
        int num = in.nextInt();
        String octal = ""; //Initialize string to display binary
        for (int i = num; i > 0; i /= 8) {
            octal = (i % 8) + octal;
        }
        String check = Integer.toOctalString(num);
        System.out.println("Decimal integer " + num + " is represented as an octal number: " + octal);
        System.out.println("Check using Java built in Integer methods got: " + check);
        in.close();
    }
}