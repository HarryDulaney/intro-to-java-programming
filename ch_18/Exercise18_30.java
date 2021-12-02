package ch_18;

import java.io.*;


/**
 * 18.30 (Find words) Write a program that finds all occurrences of a word in all the files
 * under a directory, recursively.
 * Pass the parameters from the command line as follows:
 * <p>
 * java Exercise18_30 dirName word
 * For Example:
 * cmd:>> javac Exercise18_30.java
 * >>>>>> java Exercise18_30 ch_14 static
 */
public class Exercise18_30 {
    static int occurrences = 0;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Exercise18_30 dirName word");
            System.exit(0);
        }

        String directory = args[0];
        String word = args[1];
        File dir = new File(directory);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                try {
                    wordSearch(files, word, 0);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        } else {
            System.out.println("Please specify a Directory for 'dirName'. ");
        }
        System.out.println("The word: \"" + word + "\" occurs " + occurrences + " times in: " + dir.getName());

    }

    static void wordSearch(File[] files, String word, int fileIndex) throws IOException {
        /* Recursion Stopping condition */
        if (files.length == fileIndex) {
            return;
        }

        if (files[fileIndex].isFile()) {
            FileReader fileReader = new FileReader(files[fileIndex]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(word)) {
                    occurrences++;
                }
            }
        }
        wordSearch(files, word, fileIndex + 1);
    }

}
