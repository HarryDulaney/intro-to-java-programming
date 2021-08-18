package ch_18;

import java.io.*;


/**
 * 18.30 (Find words) Write a program that finds all occurrences of a word in all the files
 * under a directory, recursively.
 * Pass the parameters from the command line as follows:
 * <p>
 * java Exercise18_30 dirName word
 */
public class Exercise18_30 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Exercise18_30 dirName word");
            System.exit(0);
        }
        int occurrences = 0;

        String directory = args[0];
        String word = args[1];
        File dir = new File(directory);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isFile()) {
                        try {
                            occurrences += countOccurrences(word, f);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }

        } else {
            System.out.println("Please specify a Directory for 'dirName'. ");
        }
        System.out.println("The word: " + word + " occurs " + occurrences + " times in: " + dir.getName());

    }

    static int countOccurrences(String word, File file) throws IOException {
        int occur = 0;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(word)) {
                occur++;
            }
        }
        return occur;
    }

}
