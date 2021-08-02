package ch_12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
 * 12.13 (Count characters, words, and lines in a file)
 * Write a program that will count the number of characters,
 * words, and lines in a file. Words are separated by whitespace characters.
 * The file name should be passed as a command-line argument, as shown in Figure 12.13.
 */
public class Exercise12_13 {
    public static void main(String[] args) throws IOException {

        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Please check your file name and try again");
            System.exit(1);
        }

        int numChars = 0, numWords = 0, numLines = 0;
        String temp = "";

        try (Scanner input = new Scanner(sourceFile);) {

            while (input.hasNext()) {

                temp = input.nextLine();
                numLines++;

                String[] tempArr = temp.split(" ");

                numWords += tempArr.length;

                for (int i = tempArr.length - 1; i >= 0; i--) {
                    numChars += tempArr[i].length();
                }
            }

        }

        System.out.println("The file " + sourceFile.getName() + " has:");
        System.out.println(numChars + " Characters");
        System.out.println(numWords + " words");
        System.out.println(numLines + " lines");

    }
}
