package ch_12.exercise12_27;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * *12.27 (Replace words) Suppose you have a lot of files in a directory that contain
 * words Exercisei_j, where i and j are digits. Write a program that pads a 0
 * before i if i is a single digit and 0 before j if j is a single digit.
 * <p>
 * For example,
 * the word Exercise2_1 in a file will be replaced by Exercise02_01. In Java,
 * when you pass the symbol * from the command line, it refers to all files in
 * the directory (see Supplement III.V). Use the following command to run your
 * program.
 * java Exercise12_27 *
 */
public class Exercise12_27 {
    private static final Pattern PATTERN = Pattern.compile("Exercise\\d_\\d");
    private static final String PREFIX = "Exercise";
    private static Logger logger = LoggerFactory.getLogger(Exercise12_27.class);

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Exercise12_27 *");
            return;
        }
        if (!args[0].equals("*")) {
            System.out.println("Usage: java Exercise12_27 *");
            return;
        }

        File file = new File(".");
        if (file.list().length > 0) {
            ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
            for (File f : files) {
                if (!f.getName().equalsIgnoreCase("Exercise12_27.java")) {
                    ArrayList<String> lines = new ArrayList<>();
                    try (Scanner fileIn = new Scanner(f)) {
                        while (fileIn.hasNextLine()) {
                            lines.add(fileIn.nextLine().trim());
                        }
                        lines = handleRename(lines);

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    try (PrintWriter printWriter = new PrintWriter(f)) {
                        for (String line : lines) {
                            printWriter.println(line);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        } else {
            System.out.println("The current directory is empty.");
        }

    }

    private static ArrayList<String> handleRename(ArrayList<String> lines) {
        ArrayList<String> nuList = new ArrayList<>();
        for (String line : lines) {
            if (PATTERN.matcher(line).matches()) { // PATTERN = Pattern.compile("Exercise\\d_\\d");
                /* Use StringBuffer to handle shorter strings */
                StringBuffer stringBuffer = new StringBuffer(line.substring(line.lastIndexOf('e') + 1));
                stringBuffer.insert(0, 0);// pad first number with a "0"
                stringBuffer.insert(stringBuffer.length() - 1, 0); // pad last number with "0"
                nuList.add(PREFIX + stringBuffer.toString());
            } else {
                nuList.add(line);
            }

        }
        return nuList;
    }
}
