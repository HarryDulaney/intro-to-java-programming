package ch_17.exercise17_08;

import ch_17.exercise17_01.Exercise17_01;

import java.io.*;
import java.util.*;

/**
 * *17.8 (Update count) Suppose you wish to track how many times a program has been
 * executed. You can store an int to count the file. Increase the count by 1 each
 * time this program is executed. Let the program be Exercise17_08 and store the
 * count in Exercise17_08.dat.
 * <p>
 *
 */
public class Exercise17_08 {
    public static void main(String[] args) throws FileNotFoundException {
        int runs = 0;
        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String path = packageParts[0] + File.separator + packageParts[1] + File.separator +
                "Exercise17_08.dat";

        File file = new File(path);
        if (!file.exists()) {
            runs = 1;
            writeFile(runs, file);
        } else {
            runs = readFile(file);
            writeFile(++runs, file);
        }
        System.out.println("Number of runs: " + runs);
    }

    static int readFile(File file) {
        int i = 0;
        try (DataInputStream dIs = new DataInputStream(new FileInputStream(file))) {
            i = dIs.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong reading the data file...@ -> " + file.getName());
        }
        return i;

    }

    static void writeFile(int i, File file) {
        try (DataOutputStream das = new DataOutputStream(new FileOutputStream(file))) {
            das.writeInt(i);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong writing the data file...@ -> " + file.getName());

        }
    }
}