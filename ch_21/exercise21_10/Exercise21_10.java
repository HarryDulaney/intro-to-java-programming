package ch_21.exercise21_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 21.10 (Count the occurrences of each keyword) Rewrite Listing 21.7 CountKeywords.
 * java to read in a Java source code file and count the occurrence of each keyword
 * in the file, but don’t count the keyword if it is in a comment or in a string literal.
 * <p>
 * test run:
 * java Exercise21_10 ch_21/exercise21_10/FileToTest.java
 */
public class Exercise21_10 {
    private static final String[] KEY_WORDS = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise21_10 FileToTest.java");
            System.exit(1);
        }

        String inputFile = args[0];
        System.out.println("Reading file: " + inputFile);

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(inputFile));
            System.out.println("Reading complete.\nMapping input file...");
        } catch (IOException e) {
            System.out.println("Something went wrong during read...");
            e.printStackTrace();
        }
        if (lines.size() < 1) {
            System.out.println("Source code file " + args[0] + " was empty...");
            System.exit(2);
        }
        Map<String, Integer> keywordMap = new HashMap<>(); // Create a HashMap to hold words as key and count as value
        for (int line = 0; line < lines.size(); line++) {
            String[] words = lines.get(line).split("[ \n\t\r.,;:!?(){]");
            for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {
                String key = words[wordIdx];
                if (key.length() > 0) {
                    if (key.startsWith("\"")) { // Start string literal
                        // Loop over line until string literal is closed
                        while (++wordIdx < words.length) {
                            key = words[wordIdx];
                            if (key.endsWith("\"")) { // End String literal
                                break; //Exit this inner loop and continue counting keywords
                            }
                        }
                    } else if (key.equals("//")) {
                        wordIdx = words.length - 1; // Move i to the end of the current line
                    } else if (key.equals("/*") || key.equals("/**")) {
                        // Here inside multiline comment, loop until finding comment close '*/'
                        while (true) {
                            wordIdx++; // Iterate to next word index
                            if (!(wordIdx < words.length)) { // Check if end of line is reached
                                if ((line + 1) < lines.size()) { // Check if next line exists
                                    line++; // Iterate to next line
                                    words = lines.get(line).split("[ \n\t\r.,;:!?(){]"); // Get words array for line
                                    wordIdx = 0; // reset index to start of next line
                                    if (words[wordIdx].equals("*/")) {
                                        break; // Exit inner while loop to continue normal iteration
                                    }
                                } else { // If no lines are left
                                    line++; // Ensure outer loop will end
                                    break; // Exit inner while loop
                                }
                            } else {
                                if (words[wordIdx].equals("*/")) {
                                    break; // Exit inner while loop to continue normal iteration
                                }
                            }

                        }
                    } else if (isJavaKeyWord(key)) { // Check if word is Java keyword
                        if (!keywordMap.containsKey(key)) {
                            keywordMap.put(key, 1);
                        } else {
                            int value = keywordMap.get(key);
                            value++;
                            keywordMap.put(key, value);
                        }
                    }
                }
            }
        }

        ArrayList<WordOccurrence> wordOccurrences = new ArrayList<>();
        // Get all entries into a set
        Set<Map.Entry<String, Integer>> entrySet = keywordMap.entrySet();
        // Get key and value from each entry
        for (Map.Entry<String, Integer> entry : entrySet) {
            wordOccurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordOccurrences);
        for (WordOccurrence wordOccurrence : wordOccurrences) {
            System.out.println(wordOccurrence);
        }
    }

    private static boolean isJavaKeyWord(String key) {
        for (String keyword : KEY_WORDS) {
            if (key.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    private static class WordOccurrence implements Comparable<WordOccurrence> {
        String word;
        int count;

        public WordOccurrence(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordOccurrence that) {
            return Integer.compare(this.count, that.count);
        }

        @Override
        public String toString() {
            return "WordOccurrence{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

}