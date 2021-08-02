package ch_17.exercise17_03;

import ch_17.exercise17_01.Exercise17_01;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * *17.3 (Sum all the integers in a binary data file) Suppose a binary data file named
 * Exercise17_03.dat has been created and its data are created using
 * writeInt(int) in DataOutputStream. The file contains an unspecified
 * number of integers. Write a program to find the sum of the integers
 *
 */
public class Exercise17_03 {
    public static void main(String[] args) {

        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String filePath = packageParts[0] + File.separator + packageParts[1] + File.separator + "Exercise17_03.dat";
        if (!(new File(filePath).exists())) {
            try (FileOutputStream fis = new FileOutputStream(filePath)) {
                DataOutputStream dos = new DataOutputStream(fis);
                runCreateTestDatFile(dos);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getLocalizedMessage());
            }

        }
        try (FileInputStream fis = new FileInputStream(filePath)) {
            DataInputStream dis = new DataInputStream(fis);

            int sum = 0;
            int numIntegers = dis.available() / 4; // An integer is stored as 4 bytes

            System.out.print("The sum of: ");
            for (int i = 0; i < numIntegers; i++) {
                int n = dis.readInt();
                if (i == 0) {
                    System.out.print(n + "");
                } else {
                    System.out.print(" + " + n);
                }
                sum += n;
            }
            System.out.println(" = " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void runCreateTestDatFile(DataOutputStream dos) throws IOException {
        for (int i = 0; i < 10; i++) {
            int n = (int) (1 + Math.random() * 10);
            dos.writeInt(n);
        }
        dos.flush();
        dos.close();

    }
}