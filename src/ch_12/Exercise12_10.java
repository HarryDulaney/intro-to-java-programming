package ch_12;

import java.util.Stack;

/**
 * 12.10 (OutOfMemoryError) Write a program that causes the JVM to throw an
 * OutOfMemoryError and catches and handles this error.
 */
public class Exercise12_10 {
    public static void main(String[] args) throws Exception {
        try {
            long[] testHeap = new long[50];
            for (int loop = 0; ; loop++) {
                testHeap = new long[testHeap.length * 4]; //Indefinitely increase array size inside of loop
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error: " + e);
        }
    }
}