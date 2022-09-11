package ch_22.exercise22_08;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Integration Test will print out the prime numbers from PrimeNumbers.dat
 */
public class Test {
    private static final String[] packageParts = Exercise22_08.class.getPackage().getName().split("\\.");
    private static final String PATH = packageParts[0] + File.separator + packageParts[1] + File.separator + "PrimeNumbers.dat";

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(PATH), "rw");
            while (true) {
                long nextLong = randomAccessFile.readLong();
                System.out.println("Next long: " + nextLong);
            }
        } catch (EOFException eof) {
            System.out.println("EOF reached");
        } catch (IOException ioException) {
            System.out.println("IOException while creating in and out file stream: \n" + ioException.getMessage());
        }
    }
}
