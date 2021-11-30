package ch_21.exercise21_08;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * **21.8 (Count the occurrences of words in a text file) Rewrite Listing 21.9 to read the
 * text from a text file. The text file is passed as a command-line argument. Words
 * are delimited by whitespace characters, punctuation marks (,;.:?), quotation
 * marks ('"), and parentheses. Count words in case-insensitive fashion (e.g., consider Good and good to be the same word).
 * The words must start with a letter.
 * Display the output in alphabetical order of words, with each word preceded by
 * its occurrence count.
 */
public class Exercise21_08 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java Exercise21_08 ch_21/exercise21_08/test.txt");
            System.exit(1);
        }

        String filePath = args[0];
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        try {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                System.out.println("Error: " + file.getCanonicalPath() + " does not exist or is not a file.");
                System.exit(2);
            }

            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                // Split input file contents by delimiters
                String[] words = line.split("[ @!~{}\\[\\]$#^&*\n\t\r.,;?'\")(]");

                for (int i = 0; i < words.length; i++) {
                    // Check for uppercase letters in words and make them lowercase (case-insensitive)
                    if (words[i].trim().length() > 0 && words[i].trim().matches("[A-Z|a-z]+")) {
                        String key = words[i].toLowerCase();
                        if (treeMap.get(key) != null) {
                            int count = treeMap.get(key);
                            count++;
                            treeMap.put(key, count);
                        } else {
                            treeMap.put(key, 1);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Get an entry set for the tree map
        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();

        // Display words in alphabetical order
        System.out.println("\nDisplay the output in alphabetical order of words, with each word preceded by\n" +
                "its occurrence count");
        for (Map.Entry<String, Integer> entry : entrySet)
            System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
}


