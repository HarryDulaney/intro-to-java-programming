package ch_20;

import java.io.File;

/**
 * 20.18 (Directory size) Listing 20.7, DirectorySize.java, gives a recursive method for
 * finding a directory size. Rewrite this method without using recursion. Your
 * program should use a queue to store the subdirectories under a directory. The
 * algorithm can be described as follows:
 * long getSize(File directory) {
 * long size = 0;
 * add directory to the queue;
 * while (queue is not empty) {
 * Remove an item from the queue into t;
 * if (t is a file)
 * size += t.length();
 * else
 * add all the files and subdirectories under t into the
 * queue;
 * }
 * return size;
 * }
 */
public class Exercise20_18 {
    private static final String TEST_DIRECTORY = "ch_09";

    public static void main(String[] args) {
        String rawSize = String.valueOf(new Exercise20_18().getSize(new File(TEST_DIRECTORY)));
        StringBuilder sizeInBytes = new StringBuilder();
        for (int i = rawSize.length() - 1; i >= 0; i--) {
            sizeInBytes.append(rawSize.charAt(i));
            if (i % 3 == 0) {
                sizeInBytes.append(",");
            }
        }
        System.out.println("Size of test directory: " + TEST_DIRECTORY + " is " + sizeInBytes + " bytes");
    }

    private long getSize(File directory) {
        long size = 0;
        java.util.Queue<File> queue = new java.util.LinkedList<>();
        queue.offer(directory);
        while (queue.size() > 0) {
            File t = queue.remove();
            if (t.isFile()) {
                size += t.length();
            } else {
                File[] subFiles = t.listFiles();
                if (subFiles == null || subFiles.length == 0) {
                    continue;
                }

                for (File f : subFiles) {
                    queue.offer(f);
                }
            }
        }
        return size;
    }
}
