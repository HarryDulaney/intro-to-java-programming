package ch_17.exercise17_19;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 17.19 (View hex) Write a program that prompts the user to enter a file name, reads bytes
 * from the file, and displays each byte’s hex representation. (Hint: You can first
 * convert the byte value into an 8-bit string, then convert the bit string into a two-digit hex string.)
 * <p>
 * Example test input: ch_17/exercise17_19/testFile.txt
 */
public class Exercise17_19 {
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
                System.out.println("Read byte value = " + val);
                int asInteger = Integer.parseInt(val, 2);
                strBytes.add(Integer.toHexString(asInteger).toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The byte contents of the file, converted to hex are: ");
        System.out.println(strBytes.toString());
    }

    public static String getBits(int value) {
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            bits.insert(0, (value & 1));
            value >>= 1;
        }
        return bits.toString();
    }
}
