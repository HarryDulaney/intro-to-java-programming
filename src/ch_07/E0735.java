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
 */
public class E0735{
     public static void main(String[] args) {
    }
}