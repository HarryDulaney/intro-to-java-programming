package ch_12.exercise12_12;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * *12.12 (Reformat Java source code) Write a program that converts the Java source
 * code from the next-line brace style to the end-of-line brace style. For example,
 * the following Java source in (a) uses the next-line brace style. Your program
 * converts it to the end-of-line brace style in (b).
 * public class Test
 * {
 * public static void main(String[] args)
 * {
 * // Some statements
 * }
 * }
 * (a) Next-line brace style
 * public class Test {
 * public static void main(String[] args) {
 * // Some statements
 * }
 * }
 * (b) End-of-line brace style
 * <p>
 * Your program can be invoked from the command line with the Java sourcecode file as the argument.
 * <p>
 * It converts the Java source code to a new format. For
 * example, the following command converts the Java source-code file Test.java
 * to the end-of-line brace style.
 * java Exercise12_12 Test.java
 */
public class Exercise12_12 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        if (args.length < 1) {
            System.out.println("Usage: java Exercise12_12 sourceFile");
            return;
        }
        File file = new File(args[0]);

        if (file.exists()) {

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);

                }

                for (int i = 1; i < lines.size(); i++) {
                    if (lines.get(i).contains("{")) {
                        String orgLine = lines.get(i);
                        orgLine = orgLine.replace('{', ' '); //Remove open bracket
                        String targetLine = lines.get(i - 1); //Get preceding line of open bracket
                        targetLine = targetLine + " {"; // Add the bracket to the end of line
                        lines.set(i, orgLine);
                        lines.set(i - 1, targetLine);
                    }
                }
                PrintWriter writer = new PrintWriter(file);

                for (String line : lines) {
                    writer.println(line);
                }
                writer.close();


            } catch (FileNotFoundException e) {
                System.out.println("File could not be found to exist: " + e);

            }
        }
    }
}
