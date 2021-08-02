package ch_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 12.19 (Count words) Write a program that counts the number of words in President
 * Abraham Lincoln’s Gettysburg address from http://cs.armstrong.edu/liang/data/
 * Lincoln.txt. (Substituted http://se.cs.depaul.edu/Java/Chapter04/Lincoln.txt)
 */
public class Exercise12_19 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://se.cs.depaul.edu/Java/Chapter04/Lincoln.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("Number of words in the Gettysburg Address is " + countWords(bufferedReader));
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s");
            if (words.length == 0) continue;
            for (String word : words) {
                word = word.trim();
                if (word.length() > 0 && !word.equals(" ")) {
                    wordCount++;
//                    System.out.println("Word: " + word + " Count = " + wordCount);
                }
            }
        }
        return wordCount;
    }
}
