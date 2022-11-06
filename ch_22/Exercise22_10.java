package ch_22;

import ch_22.exercise22_08.Exercise22_08;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 22.10 (Number of prime numbers) Programming Exercise 22.8 stores the prime numbers in a file named PrimeNumbers.dat.
 * Write a program that finds the number of prime numbers that are less than or equal to 10, 100, 1,000, 10,000,
 * 100,000, 1,000,000, 10,000,000, 100,000,000, 1,000,000,000, and
 * 10,000,000,000. Your program should read the data from PrimeNumbers.dat
 */
public class Exercise22_10 {
    private static final String[] packageParts = Exercise22_08.class.getPackage().getName().split("\\.");
    private static final String PATH = packageParts[0] + File.separator + packageParts[1] + File.separator + "PrimeNumbers.dat";

    public static void main(String[] args) {
        try {
            File dataFile = new File(PATH);
            RandomAccessFile randomAccessFile = new RandomAccessFile(dataFile, "r");
            long count = 0;
            for (long i = 10; i <= 10_000_000_000L; i *= 10) {

            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getLocalizedMessage());
        }
    }
}
