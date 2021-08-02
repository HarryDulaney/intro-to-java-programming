package ch_17.exercise17_04;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * *17.4 (Convert a text file into UTF) Write a program that reads lines of characters from
 * a text file and writes each line as a UTF-8 string into a binary file. Display the
 * sizes of the text file and the binary file. Use the following command to run the
 * program:
 * <p>
 * java ch_17.exercise17_04.Exercise17_04 Welcome.java Welcome.utf
 * <p>
 * <p>
 * To Run:  open ch_17 folder in Terminal,
 * cmdline: javac ch_17.exercise17_04.Exercise17_04.java
 * cmdline: java ch_17.exercise17_04.Exercise17_04 textfile.txt nameForOutFile.utf
 *
 */
public class Exercise17_04 {
    public static void main(String[] args) {

        if (args[0] == null) {
            return;
        } else if (args[1] == null || !args[1].endsWith(".utf")) {
            return;
        }
        List<String> lines = new ArrayList<>();
        File fileIn;
        URL pathIn = Exercise17_04.class.getResource(args[0]);
        File fileOut = new File(args[1]);

        try {
            fileIn = new File(pathIn.toURI());
            System.out.println("Begin reading the input file.. File size is " + fileIn.length() + " bytes. ");
            try (Scanner fileScan = new Scanner(fileIn);) {
                while (fileScan.hasNextLine()) {
                    String line = fileScan.nextLine();
                    System.out.println("Read: ..." + line.substring((line.length() / 3)));
                    lines.add(line);
                }
                System.out.println("Done reading the input file...");

                try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileOut))) {
                    System.out.println("Writing the output file.. " + fileOut.getName());
                    for (String line : lines) {
                        out.writeUTF(line);
                    }
                    System.out.println("Done writing the output file -> " + fileOut.getName());
                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                    System.out.println("Error finding the file to write to....");
                } catch (IOException ioe) {
                    System.out.println("Error writing output to: " + fileOut.getName());
                    ioe.printStackTrace();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileOut, "r");
                System.out.println("The size of " + fileOut.getName() + " is " + randomAccessFile.length() + " bytes.");
                randomAccessFile.close();


            } catch (IOException e) {
                System.out.println("Error reading input from: " + fileIn.getName());
                e.printStackTrace();
            }
        } catch (URISyntaxException urie) {
            urie.printStackTrace();
        }
    }
}