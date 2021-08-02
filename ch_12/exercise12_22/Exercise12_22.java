package ch_12.exercise12_22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * *12.22 (Replace text) Revise Programming Exercise 12.16 to replace a string in a file
 * with a new string for all files in the specified directory using the command:
 * <p>
 * java Exercise12_22 dir oldString newString
 * <p>
 * example cmd: java Exercise12_22 testDirectory test fun
 * or if testFile.txt's already have the word fun switch to:
 * cmd:  java Exercise12_22 testDirectory fun test
 */
public class Exercise12_22 {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println(
                    "Run: java Exercise12_16 fileName oldString newString");
            System.out.println(args.length);
            System.exit(1);
        }

        File[] files = new File(args[0]).listFiles();

        if (files == null) {
            System.out.println("Directory: " + args[0] + " is not a valid file directory.");
            System.exit(2);
        }
        for (File f : files) {
            replaceStrNextFile(f, args[1], args[2]);
        }

    }

    static void replaceStrNextFile(File file, String oldString, String nuString) {
        ArrayList<String> strHelper = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(oldString, nuString);
                strHelper.add(s2);

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 0; i < strHelper.size(); i++) {
                output.println(strHelper.remove(i));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
