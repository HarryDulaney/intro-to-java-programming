package ch_21;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * *21.12 (Name for both genders) Write a program that prompts the user to enter one of
 * the filenames described in Programming Exercise 12.31 and displays the names
 * that are used for both genders in the file. Use sets to store names and find common names in two sets.
 * Here is a sample run:
 * Enter a file name for baby name ranking: babynamesranking2001.txt
 * 69 names used for both genders
 * They are Tyler Ryan Christian ...
 */
public class Exercise21_12 {
    static final String BABY_NAMES_BASE_URL = "https://liveexample.pearsoncmg.com/data/";
    static final String START_FILE_NAME = "babynamesranking";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a file name for baby name ranking: ");
        String fileName = in.next().trim();
        // Validate user input
        if (!fileName.startsWith(START_FILE_NAME)) {
            System.out.println("File name must start with: " + START_FILE_NAME);
            System.exit(1);
        }
        // Extract year value form filename
        int year = Integer.parseInt(fileName.split("\\.")[0].substring(START_FILE_NAME.length()));
        if (year < 2001 || year > 2010) { // Validate year
            System.out.println("Year in file name must be > 2000 and < 2011.");
            System.exit(2);
        }
        // Resolve the full URL path
        String fullFilePath = BABY_NAMES_BASE_URL + fileName;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        try {
            getNamesList(set2, set1, fullFilePath); // Use url path to fetch populate Sets
            set1.retainAll(set2); // Retain all values in set1 that exist in set2 (Intersection)
            System.out.println(set1.size() + " names used for both genders");
            System.out.print("They are ");
            int perLine = 0;
            for (String name : set1) {
                if (perLine % 10 == 0 && perLine != 0) {
                    System.out.print("\t\n"); // End line
                }
                System.out.print(name + " ");
                perLine++;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong reading the URL created from the filename input...");
        }

        in.close();
    }

    static void getNamesList(Set<String> guyNameList,
                             Set<String> girlNameList,
                             String urlString) throws IOException {
        URL url = new URL(urlString);
        Scanner urlScanner = new Scanner(url.openStream());
        while (urlScanner.hasNextLine()) {
            String line = urlScanner.nextLine();
            String[] record = line.split("\\s+"); // Split line example result: {"1","Jacob","32,550","Emily","25,057"}
            String guyName = record[1];
            String girlName = record[3];
            guyNameList.add(guyName);
            girlNameList.add(girlName);

        }
        urlScanner.close();
    }

}
