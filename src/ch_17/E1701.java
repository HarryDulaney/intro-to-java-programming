package ch_17;

import java.io.*;
import java.util.Objects;
import java.util.Random;

/**
 * *17.1 (Create a text file) Write a program to create a file named Exercise17_01.txt if
 * it does not exist. Append new data to it if it already exists. Write 100 integers
 * created randomly into the file using text I/O. Integers are separated by a space.
 *
 * @author Harry Dulaney
 */
public class E1701 {
    public static void main(String[] args) {
        String filePath =
                "src" + File.separator + E1701.class.getPackage().getName() + File.separator +
                        "Exercise17_01.txt";
        File file = new File(filePath);
        PrintWriter printWriter = null;
        try {
            if (file.exists()) {
                printWriter = new PrintWriter(new FileOutputStream(new File(filePath), true));
            } else {
                printWriter = new PrintWriter(file);
            }
            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(100);
                sb.append(num).append(" ");
            }
            printWriter.write(sb.toString());
            printWriter.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurred.");
        }


    }


}
