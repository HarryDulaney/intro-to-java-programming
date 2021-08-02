package ch_05;

import java.util.*;

/**
 * *5.48 (Process string)
 * Write a program that prompts the user to enter a string and displays the characters at odd positions.
 * Here is a sample run:
 * Enter a string: Beijing Chicago
 * BiigCiao
 *
 * By: Harry Dulaney
 */
public class Exercise05_48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res = "";

        System.out.print("Enter a string: ");
        String userStr = in.nextLine();
        userStr = "h" + userStr; //Account for the weird interpretation of 'odd positions' [ie(index 0 is position 1)]

        for (int i = 0; i < userStr.length(); i++) {
            if (Character.isLetter(userStr.charAt(i))) {
                switch (i % 2) {
                    case 0:
                        break;
                    default:
                        res += userStr.charAt(i);
                        break;
                }
            }
        }
        in.close();
        System.out.println(res);
    }
}