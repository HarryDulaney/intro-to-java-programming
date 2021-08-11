package ch_21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * *21.4 (Count consonants and vowels) Write a program that prompts the user to enter a
 * text file name and displays the number of vowels and consonants in the file. Use
 * a set to store the vowels A, E, I, O, and U.
 * {textfile.txt}
 *
 */
public class Exercise21_04 {
    static int numVowels;
    static int numConsonants;

    static HashSet<Character> vowels = new HashSet<>();

    static {

        Collections.addAll(vowels, 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of a text file to read: ");
        String fileName = in.nextLine().trim();
        if (!(new File(fileName).exists())) {
            fileName = "src" + File.separator + "resources" + File.separator + fileName;

        }

        File file = new File(fileName);
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    for (int i = 0; i < word.length(); i++) {

                        char character = word.charAt(i);
                        if (Character.isLetter(character)) {
                            if (vowels.contains(character)) {
                                numVowels++;
                            } else {
                                numConsonants++;
                            }
                        }
                    }

                }

            }
            fileScanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } finally {
            in.close();
        }
        System.out.println("Number of vowels = " + numVowels);
        System.out.println("Number of consonants = " + numConsonants);
    }

}
