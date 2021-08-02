package ch_17.exercise17_14;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * 17.14 (Encrypt files) Encode the file by adding 5 to every byte in the file.
 * <p>
 * Write a program that prompts the user to enter an input file name and an output file name and
 * saves the encrypted version of the input file to the output file.
 */
public class Exercise17_14 {
    public static void main(String[] args) {
        String CURRENT_DIR = "ch_17" + File.separator + "exercise17_14";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the input file name to be encrypted: ");
        String inFileStr = in.next();

        File inputFile = new File(CURRENT_DIR, inFileStr);

        System.out.print("Please enter a name for the output file: ");
        String outFileStr = in.next();

        File outputFile = new File(CURRENT_DIR, outFileStr);
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            try {
                byte[] inBytes = Files.readAllBytes(inputFile.toPath());
                for (byte b : inBytes) {
                    bufferedOutputStream.write(b + 5);
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
