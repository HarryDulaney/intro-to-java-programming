package ch_17.exercise17_10;

import java.io.*;
import java.nio.file.Files;

/**
 * *17.10 (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI file) to a
 * CD-R. You can achieve it by splitting the file into smaller pieces and backing up
 * these pieces separately. Write a utility program that splits a large file into smaller
 * ones using the following command:
 * <p>
 * java Exercise17_10 SourceFile numberOfPieces
 */
public class Exercise17_10 {
    /**
     * Main method
     *
     * @param args [0] for sourceFile (Should be located in current package)
     * @param args [1] for numberOfOutputFiles
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("No parameters were passed....");
            System.out.println("Usage: java Exercise17_10 SourceFile numberOfPieces");
            return;
        }

        File sourceFile = new File("ch_17/exercise17_10", args[0]);

        int numberOfPieces = Integer.parseInt(args[1]);
        File outDirectory = new File(sourceFile.getParent(),"Result_Dir");
        outDirectory.mkdir();

        File[] outFiles = new File[numberOfPieces];
        String outFilesBaseName = sourceFile.getName() + "_bak_";
        for (int i = 0; i < outFiles.length; i++) {
            outFiles[i] = new File(outDirectory,outFilesBaseName + (i + 1) + ".dat");
        }
        try {

            byte[] bytes = Files.readAllBytes(sourceFile.toPath());
            int bytePerFile = bytes.length / numberOfPieces;
            int masterByteArrayIndex = 0;
            for (File file : outFiles) {
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
                for (int i = 0; i < bytePerFile; i++) {
                    outputStream.write(bytes[masterByteArrayIndex]);
                    masterByteArrayIndex++;
                }
                outputStream.flush();
                outputStream.close();
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
