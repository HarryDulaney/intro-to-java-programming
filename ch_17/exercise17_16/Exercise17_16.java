package ch_17.exercise17_16;


import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 17.16 (Frequency of characters) Write a program that prompts the user to enter the
 * name of an ASCII text file and displays the frequency of the characters in the file.
 * <i>File should be located in the exercise17_16 package...</i>
 */
public class Exercise17_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of an ASCII text file: ");
        String fileName = in.next();
        if (!fileName.isEmpty()) {
            File file = new File("ch_17/exercise17_16", File.separator + fileName);
            int totalChars = 0;
            int totalLines = 1;
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                int nextChar;
                while ((nextChar = fileInputStream.read()) != -1) {
                    char ch = (char) nextChar;
                    if (ch != ' ') {
                        totalChars++;
                    }
                    if (ch == '\n') {
                        totalLines++;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("There are " + totalChars + " total characters in the file.");
            System.out.println("There are " + totalLines + " total lines in the file.");
            System.out.println("So the file has an average of " + totalChars / totalLines + " characters per line.");

        } else {
            System.out.println("Please enter a file name in the prompt...");
            System.exit(1);
        }

        in.close();
    }
}
