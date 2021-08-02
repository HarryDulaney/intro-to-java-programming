package ch_12;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

/**
 * 12.11 (Remove text) Write a program that removes all the
 * occurrences of a specified string from a text file.
 * For example, invoking
 * <p>
 * java Exercise12_11 John filename
 * <p>
 * removes the string John from the specified file.
 * Your program should get the arguments from the command line.
 *
 * @author Harry D.
 */
public class Exercise12_11 {
    public static void main(String[] args) throws Exception {

        String toRemove = args[0];

        File sourceFile = new File(args[1]);

        if (!sourceFile.exists()) {
            System.out.println("The file " + sourceFile.getName() + "does not exist.");
            System.exit(1);
        }

        Scanner in = new Scanner(sourceFile);


        String str1 = "";
        String str2 = "";

        while (in.hasNext()) {

            str1 += in.nextLine();
            str2 = str1.replaceAll(toRemove, "");

        }

        File targetFile = new File(toRemove + "_Revised.txt");

        try (
                PrintWriter out = new PrintWriter(targetFile);
        ) {
            out.print(str2);
        }

        in.close();

        System.out.println("Your edited file is complete.");
    }
}
