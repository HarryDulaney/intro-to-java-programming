package ch_22.exercise22_08;

import ch_22.Exercise22_12;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * PrimeStorage class is used to store prime numbers in a file.
 * Used in {@link Exercise22_08} and {@link Exercise22_12 } to read/write/evaluate prime numbers
 * from the filesystem.
 */
public class PrimeStorage {
    protected File dataFile;
    private boolean firstRun;
    private long nextNumberToCheck = 0;
    private RandomAccessFile randomAccessFile;


    public PrimeStorage(String storageFilePath) throws Exception {
        dataFile = new File(storageFilePath);
        boolean createdOrExists = dataFile.exists();
        /* If file does not exist, this is the first run, starting from first prime number */
        if (!createdOrExists) {
            this.firstRun = true;
            try {
                createdOrExists = dataFile.createNewFile();
            } catch (IOException ioe) {
                throw new Exception("Error while trying to create storage file: " + ioe.getLocalizedMessage());
            }
        }

        if (createdOrExists) {
            /* Need file channel to be: Closable, seekable, readable, writable */
            try {
                randomAccessFile = new RandomAccessFile(dataFile, "rws");
                // Handle different startup flows
                if (firstRun) {
                    nextNumberToCheck = initializePrimes();
                } else {
                    nextNumberToCheck = restartPrimes();
                }
            } catch (IOException ioException) {
                throw new Exception("IOException while creating in and out file stream: \n" + ioException.getMessage());
            }
        }

    }

    private long restartPrimes() throws IOException {
        long totalBytes = randomAccessFile.length();
        randomAccessFile.seek(totalBytes - 8); // Seek to read the last 8 bytes in the file
        long lastPrime = randomAccessFile.readLong();
        return nextNumberToCheck = lastPrime + 1;
    }


    private long initializePrimes() throws IOException {
        /* First time running program, prep the file by writing first two prime numbers */
        randomAccessFile.writeLong(2L);
        randomAccessFile.writeLong(3L);
        return 4;
    }

    public long[] readNextPrimes() {
        long[] primes = new long[10000];
        try {
            for (int i = 0; i < primes.length && (randomAccessFile.getFilePointer() < randomAccessFile.length()); i++) {
                primes[i] = randomAccessFile.readLong();
            }
        } catch (EOFException eof) {
            System.out.println("End of File Reached");
            return primes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return primes;
    }

    public void appendPrime(long primeNumber) throws IOException {
        long totalBytes = randomAccessFile.length();
        randomAccessFile.seek(totalBytes);
        randomAccessFile.writeLong(primeNumber);
    }

    public boolean isFirstRun() {
        return firstRun;
    }

    public long getNextNumberToCheck() {
        return nextNumberToCheck;
    }

    public void setNextNumberToCheck(long nextNumberToCheck) {
        this.nextNumberToCheck = nextNumberToCheck;
    }

    public void setPosition(long position) throws IOException {
        randomAccessFile.seek(position);
    }
}
