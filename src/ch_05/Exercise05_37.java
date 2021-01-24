package ch_05;

import java.math.BigInteger;
import java.util.*;

/**
 * **5.37 (Decimal to binary) Write a program that prompts the user to enter a decimal
 * integer and displays its corresponding binary value.
 * <p>
 * Do not use Java’s Integer.toBinaryString(int) in this program...
 */
public class Exercise05_37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a decimal integer: ");
        int num = in.nextInt();
        String bin = ""; //Initialize string to display binary
        for (int i = num; i > 0; i /= 2) {
            bin = (i % 2 == 0 ? "0" : "1") + bin;
        }
        System.out.println("Calculated using brute force algorithm: Decimal integer " + num + " is represented by the" +
                " " +
                "binary number: " + bin);

        String check = Integer.toBinaryString(num);
        System.out.println("Check using Java built in Integer methods got: " + check);
        in.close();
    }
}