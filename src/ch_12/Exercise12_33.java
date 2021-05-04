package ch_12;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **12.33 (Search Web) Modify Listing 12.18 WebCrawler.java to search for the word
 * Computer Programming starting from the URL http://cs.armstrong.edu/liang.
 * Your program terminates once the word is found. Display the URL for the page
 * that contains the word.
 * <p>
 * Because http://cs.armstrong.edu/liang is no longer active I substituted that with:
 * http://liveexample.pearsoncmg.com/liang/intro10e
 * <p>
 * And searched for the words: "Object-Oriented" instead of "Computer Programming" because it would yield zero results.
 */
public class Exercise12_33 {
    public static void main(String[] args) {
        String startURL = "https://liveexample.pearsoncmg.com/liang/intro10e/toc.html";
        crawl(startURL);
    }

    public static void crawl(String url) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();
        listOfPendingURLs.add(url);

        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                System.out.println("Craw " + urlString);
                for (String s : getSubURLs(urlString)) {
                    if (!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            while (input.hasNextLine()) {
                String line = input.nextLine();
                int startIdxLink = line.indexOf("<a href=\"");
                int endIdxLink = line.indexOf("</a>") + startIdxLink;
                String link = line.substring(startIdxLink, endIdxLink);
                for (int i = endIdxLink; i >= link.length() - startIdxLink; i--) {

                }

            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
