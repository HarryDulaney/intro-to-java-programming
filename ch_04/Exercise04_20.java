package ch_04; 
 
import java.util.*;

/**
 * 4.20 (Process a string) Write a program that prompts the user to enter a string and displays its length and its first character
 */
public class Exercise04_20 {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         System.out.println("Enter a string: ");
         String s = in.next();
         System.out.println("Length is " + s.length() + " First char is " + s.charAt(0) );


    }
}