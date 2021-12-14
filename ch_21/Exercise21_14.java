package ch_21;

import java.net.URL;
import java.util.*;

/**
 * *21.14 (Web crawler) Rewrite Listing 12.18, WebCrawler.java,
 * to improve the performance by using appropriate
 * new data structures for listOfPendingURLs and listofTraversedURLs.
 */
public class Exercise21_14 {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Traverse the Web from the a starting url
    }

    public static void crawler(String startingURL) {
        /* Exercise 21.14
         ...improve the performance by using appropriate new data structures for listOfPendingURLs and
         listofTraversedURLs.
         */
        TreeSet<CrawlUrl> listOfPendingURLs = new TreeSet<>();
        HashSet<CrawlUrl> listOfTraversedURLs = new HashSet<>();
        listOfPendingURLs.add(new CrawlUrl(startingURL));
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            CrawlUrl crawUrl = listOfPendingURLs.first();
            listOfPendingURLs.remove(crawUrl);
            if (!listOfTraversedURLs.contains(crawUrl)) {
                listOfTraversedURLs.add(crawUrl);
                System.out.println("Crawl: " + crawUrl);
                for (CrawlUrl crawlUrl : getSubURLs(crawUrl.getUrlString())) {
                    if (!listOfTraversedURLs.contains(crawlUrl))
                        listOfPendingURLs.add(crawlUrl);
                }
            }
        }
    }

    public static Set<CrawlUrl> getSubURLs(String urlString) {
        Set<CrawlUrl> set = new HashSet<>(); // Exercise 21.14
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        set.add(new CrawlUrl(line.substring(current, endIndex)));
                        current = line.indexOf("http:", endIndex);
                    } else
                        current = -1;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return set;
    }
}

/**
 * Implements Comparable for default sorting when used in a TreeSet
 */
class CrawlUrl implements Comparable<CrawlUrl> {
    private String urlString;

    public CrawlUrl(String urlString) {
        this.urlString = urlString;
    }

    @Override
    public int compareTo(CrawlUrl that) {
        // Implement to sort by the length of the url
        return Integer.compare(this.urlString.length(), that.urlString.length());
    }

    public String getUrlString() {
        return urlString;
    }

    public CrawlUrl setUrlString(String urlString) {
        this.urlString = urlString;
        return this;
    }


    @Override
    public String toString() {
        return "CrawlUrl{" +
                "urlString='" + urlString + '\'' +
                '}';
    }
}