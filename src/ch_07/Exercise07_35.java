package ch_07;

import java.util.*;

/**
 * ***7.35 (Game: hangman) Write a hangman game that randomly generates a word and
 * prompts the user to guess one letter at a time, as shown in the sample run. Each
 * letter in the word is displayed as an asterisk. When the user makes a correct
 * guess, the actual letter is then displayed. When the user finishes a word, display
 * the number of misses and ask the user whether to continue to play with another
 * word. Declare an array to store words, as follows:
 * // Add any words you wish in this array
 * String[] words = {"write", "that", ...};
 * (Guess) Enter a letter in word ******* > p
 * (Guess) Enter a letter in word p****** > r
 * (Guess) Enter a letter in word pr**r** > p
 * p is already in the word
 * (Guess) Enter a letter in word pr**r** > o
 * (Guess) Enter a letter in word pro*r** > g
 * (Guess) Enter a letter in word progr** > n
 * n is not in the word
 * (Guess) Enter a letter in word progr** > m
 * (Guess) Enter a letter in word progr*m > a
 * The word is program. You missed 1 time
 * Do you want to guess another word? Enter y or n>
 *
 * @author Harry D.
 */
public class Exercise07_35 {
    static int missed = 0;
    final static String[] words = {"words", "bread", "signal", "time", "display", "friend", "computer",
            "forget",
            "java"};
    static boolean wordLoop = true;
    static boolean gameLoop = true;
    final static String prompt = "(Guess) Enter a letter in word ";
    static String currentWord;
    static int[] guessed;
    static String display;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (gameLoop) {
            currentWord = getRandomWord();
            handleNewWord();
            do {
                System.out.print(prompt + display + " >");
                String guess = in.next();
                handleGuess(guess.charAt(0));
                wordLoop = validateWord();
                if (!wordLoop) {
                    System.out.println("The word is " + currentWord + " you missed " + missed + " times.");
                }
            } while (wordLoop);
            System.out.println("Do you want to guess another word? y or n >");
            gameLoop = in.next().charAt(0) == 'y';
        }
        System.out.println("Thanks for playing hangman!");
        in.close();
    }

    private static boolean validateWord() {
        boolean gameNotOver = false;
        for (int pos : guessed) {
            if (pos == 0) {
                gameNotOver = true;
                break;
            }
        }
        return gameNotOver;
    }

    static String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }

    static void handleAsterisk() {
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (guessed[i] == 0) {
                letters[i] = '*';
            }
        }
        display = String.valueOf(letters);
    }

    static void handleNewWord() {
        guessed = new int[currentWord.length()];
        char[] d = new char[currentWord.length()];
        Arrays.fill(d, '*');
        display = String.valueOf(d);
    }

    static void handleGuess(char guess) {
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == guess) {
                if (guessed[i] != 0) {
                    System.out.println(guess + " is already in the word.");
                } else {
                    guessed[i] = 1;
                    handleAsterisk();
                    return;
                }
                break;
            }
        }
        missed++;
        System.out.println(guess + " is not in the word.");
    }
}