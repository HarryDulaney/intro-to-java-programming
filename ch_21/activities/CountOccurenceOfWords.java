package ch_21.activities;

import java.util.*;

public class CountOccurenceOfWords {

	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Where am I though?" + "Nice to see everybody. Do you know where I live!";
		// Instantiate the TreeMap
		Map<String, Integer> map = new TreeMap<>();

		// Split the string to array String array of words only
		String[] words = text.split("[ \n\t\r.,;:!?(){]");// Regex expression for split points
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);// add entry
				} else {
					int value = map.get(key);
					value++; // Increment count value
					map.put(key, value); // Update the entry with new value
				}
			}
		}
		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {

			System.out.println(entry.getValue() + "\t" + entry.getKey());

		}

	}

}
