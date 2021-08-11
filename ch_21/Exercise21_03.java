package ch_21;

import java.io.File;
import java.util.*;

/**
 * **21.3 (Count the keywords in Java source code) Revise the program in Listing 21.7.
 * <p>
 * If a keyword is in a comment or in a string, don’t count it.
 * <p>
 * Pass the Java file name from the command line.
 * <p>
 * Assume that the Java source code is correct and line comments and paragraph comments do not overlap
 * <p>
 * Run this solution in a command line terminal:
 * compile  ->  javac Exercise21_03.java
 * check keywords in Exercise21_02.java ->  java Exercise21_03 Exercise21_02.java
 */
public class Exercise21_03 {
    static boolean inString;
    static boolean inComment;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please add the source file path to read from to the command line argument.");
            return;
        }

        String filename = args[0];
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("The number of keywords in " + filename
                    + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist, or could not be found.");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();

            if (word.contains("//")) { //Rest of the line must be a comment
                System.out.println("Inside of single line comment, ignoring rest of line.");
                input.nextLine(); // Go to the next line
            } else if (word.contains("/*")) { //Start of multiline comment
                System.out.println("Inside multiline comment. Ignoring keywords now.");
                inComment = true;
                while (inComment) {
                    word = input.next(); //Start checking for to find end of comment
                    if (word.contains("*/")) { //Check for end of multiline comment on for current line
                        inComment = false;
                        System.out.println("End of multiline comment....");
                        break;
                    }
                }

            } else if (word.contains("\"")) {
                System.out.println("Inside of a String literal, now ignoring keywords.");
                inString = true;
                while (inString) {
                    word = input.next();
                    if (word.contains("\"")) {
                        inString = false;
                        System.out.println("End of String....");
                        break;
                    }
                }

            } else {
                if (keywordSet.contains(word)) {
                    System.out.println("Keyword detected: " + word);
                    count++;
                }
            }
        }
        return count;
    }
}
