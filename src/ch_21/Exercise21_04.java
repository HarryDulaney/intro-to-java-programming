package ch_21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * *21.4 (Count consonants and vowels) Write a program that prompts the user to enter a
 * text file name and displays the number of vowels and consonants in the file. Use
 * a set to store the vowels A, E, I, O, and U.
 *
 * @author Harry D.
 */
public class Exercise21_04 {
    static int numVowels;
    static int numConsonants;

    static HashSet<Character> vowels = new HashSet<>();

    static {
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter path to the text file: ");
        String filePath = in.next();
        File file = new File(filePath);
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String letter = fileScanner.next("[a-z][A-Z]");
                Character c = letter.charAt(0);
                if (vowels.contains(c)) {
                    numVowels++;

                } else {
                    numConsonants++;
                }

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println("Number of vowels = " + numVowels);
        System.out.println("Number of consonants = " + numConsonants);
    }

}
