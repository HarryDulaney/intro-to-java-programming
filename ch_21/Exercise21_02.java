package ch_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 21.2 (Display non-duplicate words in ascending order) Write a program that reads
 * words from a text file and displays all the non-duplicate words in ascending order. 
 * The text file is passed as a command-line argument.
 */
public class Exercise21_02 {
	public static void main(String[] args) {

		HashSet<String> words = new HashSet<>();

		File file = new File(args[0]);
		try (Scanner input = new Scanner(file)) {
		//Loop
			for (int i = 0; input.hasNext(); i++) {
				words.add(input.next());
			}

		} catch (FileNotFoundException ex) {
			System.out.println(
					"Invalid file input. Please insure you use " + "a .txt file and correct path, then, run again, ");
		}
		List<String> arrWords = new ArrayList<>(words);

		Collections.sort(arrWords);

		System.out.print(arrWords);
	}

}