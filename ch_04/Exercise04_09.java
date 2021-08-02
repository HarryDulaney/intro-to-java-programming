package ch_04;

import javax.xml.soap.SAAJMetaFactory;
import java.util.*;

/**
 * *4.9 (Find the Unicode of a character) Write a program that receives a character and
 * displays its Unicode. Here is a sample run:
 * Enter a character: E
 * The Unicode for the character E is 69
 */
public class Exercise04_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a character: ");
        String s = in.next("[A-Za-z\\d]");
        char myChar = s.charAt(0);
        System.out.println("The Unicode for the character " + myChar + " is " + (int) myChar);
    }
}