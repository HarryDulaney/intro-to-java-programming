package ch_17;

import java.io.*;
import java.util.*;

/**
 * *17.5 (Store objects and arrays in a file) Write a program that stores an array of the five
 * int values 1, 2, 3, 4, and 5, a Date object for the current time, and the double
 * value 5.5 into the file named Exercise17_05.dat.
 *
 * @author Harry D.
 */
public class Exercise17_05 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5}; //Arrays are stored as Object in Java
        Date date = new Date(); // Object of Date type,implements Serializable. Default constructor creates with the
        // current data/time.
        Double value = 5.5; // Implicit cast of double to wrapper type Double which implements Serializable.
        File file = new File("src" + File.separator + Exercise17_05.class.getPackage().getName() + File.separator + "Exercise17_05" +
                ".dat");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(a);
            objectOutputStream.writeObject(date);
            objectOutputStream.writeObject(a);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}