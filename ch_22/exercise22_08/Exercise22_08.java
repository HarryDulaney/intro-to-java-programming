package ch_22.exercise22_08;

import java.io.*;

/**
 * *22.8 (All prime numbers up to 10,000,000,000) Write a program that finds
 * all prime numbers up to 10,000,000,000. There are approximately
 * 455,052,511 such prime numbers. Your program should meet the following
 * requirements:
 * ■ Your program should store the prime numbers in a binary data file, named
 * PrimeNumbers.dat. When a new prime number is found, the number is
 * appended to the file.
 * ■ To find whether a new number is prime, your program should load the
 * prime numbers from the file to an array of the long type of size 10000.
 * If no number in the array is a divisor for the new number, continue to read
 * the next 10000 prime numbers from the data file, until a divisor is found
 * or all numbers in the file are read. If no divisor is found, the new number
 * is prime.
 * ■ Since this program takes a long time to finish, you should run it as a batch
 * job from a UNIX machine. If the machine is shut down and rebooted, your
 * program should resume by using the prime numbers stored in the binary data
 * file rather than start over from scratch.
 */
public class Exercise22_08 {
    private static PrimeStorage primeStorage;
    private static final String[] packageParts = Exercise22_08.class.getPackage().getName().split("\\.");
    private static final String PATH = packageParts[0] + File.separator + packageParts[1] + File.separator + "PrimeNumbers.dat";
    private static long[] primeReadBuffer = new long[10000];
    private static final long UPPER_BOUND = 10_000_000_000L;
    private static boolean reachedEndOfBuffer = false;

    public static void main(String[] args) {
        try {
            primeStorage = new PrimeStorage(PATH);
            long checkNum = primeStorage.getNextNumberToCheck();
            // Check primes until reaching upper bound
            while (checkNum < UPPER_BOUND) {
                boolean isPrime = checkPrime(checkNum, primeStorage);
                if (isPrime) {
                    primeStorage.appendPrime(checkNum);
                }
                checkNum++;
            }

        } catch (Exception e) {
            System.err.println("Could not create and/or read/write file needed to store prime numbers on this device. " +
                    "Please confirm Security Manager will allow create/read/write file storage.");
            System.exit(0);
        }

    }

    private static boolean checkPrime(long checkNum, PrimeStorage primeStorage) throws IOException {
        boolean loop = true;
        boolean isPrime = true;
        primeStorage.setPosition(0);

        while (loop) {
            primeReadBuffer = primeStorage.readNextPrimes();
            boolean isDivisible = isDivisible(primeReadBuffer, checkNum);
            if (isDivisible) {
                // checkNum is not prime
                loop = false;
                isPrime = false;
                break;
            } else if (reachedEndOfBuffer) {
                loop = false;
                break;
            }
        }

        return isPrime;
    }

    public static boolean isDivisible(long[] primes, long checkNum) {
        for (long prime : primes) {
            if (prime == 0) {
                reachedEndOfBuffer = true;
                return false;
            }
            if (checkNum % prime == 0) {
                return true;
            }
        }
        return false;
    }
}
