package ch_17.exercise17_05;

import ch_17.exercise17_01.Exercise17_01;

import java.io.*;
import java.util.*;

/**
 * *17.5 (Store objects and arrays in a file) Write a program that stores an array of the five
 * int values 1, 2, 3, 4, and 5, a Date object for the current time, and the double
 * value 5.5 into the file named Exercise17_05.dat.
 *
 */
public class Exercise17_05 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5}; //Arrays are stored as Object in Java
        Date date = new Date(); // Object of Date type,implements Serializable. Default constructor creates with the
        // current data/time.
        Double value = 5.5; // Implicit cast of double to wrapper type Double which implements Serializable.
        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String filePath = packageParts[0] + File.separator + packageParts[1] + File.separator + "Exercise17_05.dat";

        File file = new File(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(a);
            objectOutputStream.writeObject(date);
            objectOutputStream.writeObject(a);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}