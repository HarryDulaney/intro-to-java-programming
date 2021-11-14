package ch_21;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 21.6 (Count the occurrences of numbers entered) Write a program that reads an
 * unspecified number of integers and finds the one that has the most occurrences.
 * The input ends when the input is 0. For example, if you entered 2 3 40 3 5 4 –3
 * 3 3 2 0, the number 3 occurred most often. If not one but several numbers have
 * the most occurrences, all of them should be reported. For example, since 9 and 3
 * appear twice in the list 9 30 3 9 3 2 4, both occurrences should be reported.
 */
public class Exercise21_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> treeMap = new TreeMap<>();
        System.out.println("Enter space seperated integers, ending with a '0': ");
        while (in.hasNext()) {
            String key = in.next().trim();
            if (key.length() > 0) {
                if (key.equals("0")) {
                    process(treeMap);
                    return;
                } else {
                    if (!treeMap.containsKey(key)) { // Map doesn't contain the key
                        treeMap.put(key, 1); // Add the key with initial count of 1
                    } else {
                        // Map does contain the key
                        int value = treeMap.get(key);
                        value++;
                        treeMap.put(key, value);
                    }
                }
            }
        }
    }//

    private static void process(Map<String, Integer> treeMap) {
        Set<Map.Entry<String, Integer>> entries = treeMap.entrySet();
        int max = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            max = Math.max(entry.getValue(), max);
        }
        System.out.println("The most occurring number(s): ");
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == max) {
                System.out.println("" + entry.getKey());
            }
        }
    }
}
