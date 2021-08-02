package ch_12.exercise12_29;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * **12.29 (Rename files) Suppose you have a lot of files in a directory named Exercisei_j,
 * where i and j are digits. Write a program that pads a 0 before j if j is a single
 * digit. For example, a file named Exercise2_1 in a directory will be renamed to
 * Exercise2_01. In Java, when you pass the symbol * from the command line,
 * it refers to all files in the directory (see Supplement III.V). Use the following
 * command to run your program.
 * To test:
 * rename files in ./testDir by removing the '0' padding in the suffix for j.
 * <p>
 * (From inside: java-prog-dan-lang-10th/src/ch_12/exercise12_29/ ) cmd: javac Exercise12_29.java
 * cmd: cd ../..
 * cmd: java ch_12.exercise12_29.Exercise12_29 *
 */
public class Exercise12_29 {
    private static final Pattern PATTERN = Pattern.compile("Exercise\\d{1,2}_\\d.*"); //

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Exercise12_29 *");
            return;
        }
        if (!args[0].equals("*")) {
            System.out.println("Usage: java Exercise12_29 *");
            return;
        }

        File srcDirectory = new File("./testDir");
        if (!srcDirectory.isDirectory()) {
            System.out.println("The directory path is not a directory: " + srcDirectory.getAbsolutePath());
            return;
        }

        if (!Objects.isNull(srcDirectory.listFiles()) && srcDirectory.listFiles().length > 0) {
            ArrayList<File> files = new ArrayList<>(Arrays.asList(srcDirectory.listFiles()));
            for (File f : files) {
                String fileName = f.getName();
                StringBuffer stringBuffer = new StringBuffer(fileName);
                if (PATTERN.matcher(stringBuffer.toString()).matches()) {
                    stringBuffer.insert(fileName.lastIndexOf("_") + 1, "0");
                    System.out.println("Renaming: " + fileName + " to " + stringBuffer.toString());
                    Path srcPath = f.toPath();
                    Path trgtPath = Paths.get(srcDirectory.toPath().toString(), stringBuffer.toString());
                    try {
                        Files.move(srcPath, trgtPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Rename successful");
                    } catch (IOException ioe) {
                        System.out.println("Something went wrong while renaming the file... " + fileName + "\n\n");
                        ioe.printStackTrace();
                    }

                }

            }
        } else {
            System.out.println("The current directory is empty...");
        }

    }
}
