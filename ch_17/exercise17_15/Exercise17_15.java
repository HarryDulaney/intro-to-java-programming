package ch_17.exercise17_15;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * 17.15 (Decrypt files) Suppose a file is encrypted using the scheme in Programming
 * Exercise 17.14.
 * <p>
 * Write a program to decode an encrypted file. Your program
 * should prompt the user to enter an input file name for the encrypted file and an
 * output file name for the unencrypted version of the input file.
 */
public class Exercise17_15 {
    public static void main(String[] args) {
        String CURRENT_DIR = "ch_17" + File.separator + "exercise17_15";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the input file name to be decrypted: "); //TestFileEncrypted.dat
        String inFileStr = in.next();

        File inputFile = new File(CURRENT_DIR, inFileStr);

        System.out.print("Please enter a name for the output file: ");
        String outFileStr = in.next();

        File outputFile = new File(CURRENT_DIR, outFileStr);
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            try {
                byte[] inBytes = Files.readAllBytes(inputFile.toPath());
                for (byte b : inBytes) {
                    bufferedOutputStream.write(b - 5);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        in.close();
    }
}
