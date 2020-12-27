package ch_20;

import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *20.1 (Display words in ascending alphabetical order) Write a program that
 * reads words from a text file and displays all the words (duplicates allowed)
 * in ascending alphabetical order. The words must start with a letter. The text
 * file is passed as a command-line argument
 */

public class E2001 {

    public static void main(String... args) {
        String fileName = "resources/W.txt";
        E2001 e2001 = new E2001();
        File file = new File(".");
        try {
            file = e2001.getFileFromResources(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(":(" + " " + e.getLocalizedMessage());
        }

        List<String> words = new ArrayList<>();

        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNext()) {
                words.add(fileInput.next());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(words);

    }

    private File getFileFromResources(String fileName) throws URISyntaxException, FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceFile = classLoader.getResource(fileName);
        if (resourceFile == null) {
            System.out.println("File Not Found");
            throw new FileNotFoundException("File not found");
        }
        return new File(resourceFile.toURI());
    }
}
