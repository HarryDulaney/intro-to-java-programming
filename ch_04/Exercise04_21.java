package ch_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 4.21 (Check SSN) Write a program that prompts the user to enter a Social Security
 * number in the format DDD-DD-DDDD, where D is a digit.
 * <p>
 * Your program should
 * check whether the input is valid. Here are sample runs:
 * Enter a SSN: 232-23-5435
 * 232-23-5435 is a valid social security number
 * Enter a SSN: 23-23-5435
 * 23-23-5435 is an invalid social security number
 */
public class Exercise04_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Social Security number in the format DDD-DD-DDDD, where D is a digit: ");
        String userInput = in.nextLine().trim();

        String socSec = "(\\d\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)";
        Pattern ssNum = Pattern.compile(socSec);
        Matcher matcher = ssNum.matcher(userInput);
        if (matcher.matches()) {
            System.out.println(userInput + " is a valid social security number.");
        } else {
            System.out.println(userInput + " is not a valid social security number.");
        }


    }
}