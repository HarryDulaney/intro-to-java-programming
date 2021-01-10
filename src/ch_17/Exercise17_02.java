package ch_17;

import java.io.*;
import java.util.*;

/**
 * *17.2 (Create a binary data file) Write a program to create a file named
 * Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
 * Write 100 integers created randomly into the file using binary I/O.
 *
 * @author Harry Dulaney
 */

public class Exercise17_02 {
    public static void main(String[] args) {
        String filePath = "src" + File.separator + Exercise17_02.class.getPackage().getName() + File.separator +
                "Exercise17_02.dat";

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath), true)) {

            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(100);
                fileOutputStream.write(num);
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException occurred.");
        }

    }
}