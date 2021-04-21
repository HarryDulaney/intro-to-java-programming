package ch_12;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * **12.26 (Create a directory) Write a program that prompts the user to enter a directory
 * name and creates a directory using the File’s mkdirs method. The program
 * displays the message “Directory created successfully" if a directory is created
 * or “Directory already exists” if the directory already exists.
 */
public class Exercise12_26 {
    static String writePath = "src" + File.separator + Exercise12_26.class.getPackage().getName() + File.separator;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the directory name to create: ");
        String name = in.nextLine();
        if (createDirectory(writePath.concat(name))) {
            System.out.println("Directory created successfully");
        }

    }

    static boolean createDirectory(String pathToWrite) {
        Path dirPath;
        File file = new File(pathToWrite);
        if (!file.exists() && !file.isDirectory()) {
            Path dir = Paths.get(file.toURI());
            System.out.println("Preparing to create directory " + pathToWrite + " at " + file.getAbsolutePath());
            return file.mkdir();
        } else {
            System.out.println("A directory named " + pathToWrite + "already exists");
            return false;
        }
    }
}
