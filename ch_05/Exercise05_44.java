package ch_05;

import java.util.*;

/**
 * *5.44 (Computer architecture: bit-level operations) A short value is stored in 16 bits.
 * Write a program that prompts the user to enter a short integer and displays the 16
 * bits for the integer.
 * <p>
 * Here are sample runs:
 * <p>
 * Enter an integer: 5
 * The bits are 0000000000000101
 * Enter an integer: -5
 * The bits are 1111111111111011
 * (Hint: You need to use the bitwise right shift operator (>>) and the bitwise AND
 * operator (&), which are covered in Appendix G, Bitwise Operations.)
 */
public class Exercise05_44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a short integer: ");
        short number = in.nextShort();

        String bits = "";

        for (int i = 0; i < 16; i++) {
            bits = (number & 1) + bits;
            number >>= 1;
        }
        in.close();
        System.out.println("The bits are " + bits);
    }
}