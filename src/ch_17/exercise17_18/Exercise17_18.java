package ch_17.exercise17_18;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 17.18 (View bits) Write the following method that displays the bit representation for the
 * last byte in an integer:
 * public static String getBits(int value)
 * For a hint, see {@link ch_05.Exercise05_44} Programming Exercise 5.44.
 * <p>
 * Write a program that prompts the
 * user to enter a file name, reads bytes from the file, and displays each byte’s binary
 * representation.
 * Example input: src/ch_17/exercise17_17/Exercise17_17.dat
 */
public class Exercise17_18 {
    static BufferedInputStream bufferedInputStream;
    static ArrayList<String> strBytes;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        strBytes = new ArrayList<>();
        System.out.println("Enter a filename: ");
        String fileName = in.nextLine().trim();
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
            int b;
            while ((b = bufferedInputStream.read()) != -1) {
                String val = getBits(b);
                strBytes.add(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The contents of the file, converted to bytes are: ");
        System.out.println(strBytes.toString());

        in.close();
    }

    public static String getBits(int value) {
        String bits = "";
        for (int i = 0; i < 8; i++) {
            bits = (value & 1) + bits;
            value >>= 1;
        }
        return bits;
    }
}
