package ch_17.exercise17_12;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * 17.12 (Combine files) Write a utility program that combines the files together into a
 * new file using the following command:
 * java Exercise17_12 SourceFile1 . . . SourceFilen TargetFile
 * The command combines SourceFile1, . . . , and SourceFile^n into TargetFile.
 * <p>
 * Test Example:
 * <p>
 * cd ch_17/exercise17_12/
 * javac Exercise17_12.java
 * java Exercise17_12 TestFile.dat.1 TestFile.dat.2 TestFile.dat.3 TestFile.dat.4 ResultFile.dat
 */
public class Exercise17_12 {
    private static final String PARENT_PATH = "ch_17/exercise17_12";

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Exercise17_12 SourceFile1 . . . SourceFilen TargetFile");
            return;
        }
        File[] sourceFiles = new File[args.length - 1]; //Array to hold source File references excluding TargetFile
        String targetFile = args[args.length - 1]; // Last value in args is the TargetFile
        File outFile = new File(PARENT_PATH, targetFile);
        for (int i = 0; i < args.length - 1; i++) {
            sourceFiles[i] = new File(PARENT_PATH, args[i]);
        }
        try {
            combineFiles(sourceFiles, outFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void combineFiles(File[] srcFiles, File targetFile) throws Exception {
        System.out.println("Combining src files into target file: " + targetFile.getName());
        byte[][] bytes = new byte[srcFiles.length][];
        int arraysIdx = 0;
        for (File f : srcFiles) {
            System.out.println("Processing: " + f.getName());
            bytes[arraysIdx++] = Files.readAllBytes(f.toPath());
        }
        FileOutputStream outputStream = new FileOutputStream(targetFile);
        for (byte[] bytArray : bytes) {
            outputStream.write(bytArray);
        }
        outputStream.flush();
        outputStream.close();
        System.out.println("Completed: Success");
    }
}
