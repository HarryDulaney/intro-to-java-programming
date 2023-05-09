package ch_22;

import ch_22.exercise22_08.Exercise22_08;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 22.12 (Last 100 prime numbers) Programming Exercise 22.8 stores the prime numbers
 * in a file named PrimeNumbers.dat.
 * Write an efficient program that reads
 * the last 100 numbers in the file. (Hint: Don’t read all numbers from the file.
 * Skip all numbers before the last 100 numbers in the file.)
 * <p>
 */
public class Exercise22_12 {
    private static final String[] packageParts = Exercise22_08.class.getPackage().getName().split("\\.");
    private static final String PATH = packageParts[0] + File.separator + packageParts[1] + File.separator + "PrimeNumbers.dat";
    private static final long UPPER_BOUND = 10_000_000_000L;
    private static final long BYTE_PER_LONG = 8;

    public static void main(String[] args) throws Exception {
        File dataFile = new File(PATH);
        boolean createdOrExists = dataFile.exists();
        /* If file does not exist, this is the first run, starting from first prime number */
        if (!createdOrExists) {
            System.out.println("Prime Storage File from Exercise 22 08 does not exist. Please run Exercise 22 08 first.");
            System.exit(0);
        } else {
            /* Need file channel to be: Closable, seekable, readable, writable */
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(dataFile, "rws")) {
                long[] last100Primes = new long[100];
                long endOfFilePointer = randomAccessFile.length(); // Get pointer to end of the last byte in the file
                /* Calc pointer to start point for reading the last 100 numbers in the file */
                long bytePointer = endOfFilePointer - (BYTE_PER_LONG * 100); // bytes per long * 100 numbers from end
                randomAccessFile.seek(bytePointer);
                int readCount = 0;
                long nextPrime = 0;
                while (nextPrime < UPPER_BOUND && readCount < 100) {
                    nextPrime = randomAccessFile.readLong();
                    last100Primes[readCount] = nextPrime;
                    readCount++;
                }
                System.out.println("Last 100 primes in the file: ");
                System.out.println("================================");
                System.out.println(Arrays.toString(last100Primes));

            } catch (IOException ioException) {
                throw new Exception("IOException while creating in and out file stream: \n" + ioException.getMessage());
            }


        }
    }
}
