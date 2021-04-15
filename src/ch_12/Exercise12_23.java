package ch_12;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * **12.23 (Process scores in a text file on the Web) Suppose that the text file on the
 * Web http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified number
 * of scores. Write a program that reads the scores from the file and displays their
 * total and average. Scores are separated by blanks.
 */
public class Exercise12_23 {

    public static void main(String[] args) {
        double total = 0, average = 0;
        int count = 0;
        try {
//            URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt"); No longer online
            URL url = new URL("https://git.savannah.gnu.org/cgit/datamash.git/plain/examples/scores.txt");
            try (Scanner in = new Scanner(url.openStream())) {
                while (in.hasNext()) {
                    double score;
                    String nxtStr = in.next();
                    if (Character.isDigit(nxtStr.charAt(0))) {
                        score = Double.parseDouble(nxtStr);
                        count++;
                        total += score;
                    }
                }
                System.out.println("The total is " + total);
                average = total / count;
                System.out.printf("The average score was %.2f%n", average);

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }


        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

    }
}
