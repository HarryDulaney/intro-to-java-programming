package ch_07;

/**
 * 7.22 (Find the number of uppercase letters in a string)
 * Write a program that passes a string to the command
 * line and displays the number uppercase of letters in the string.
 */
public class Exercise07_22 {
    public static void main(String[] args) {

        int upperCase = 0;

        String str = args[0];

        for (int i = 0; i < str.length(); i++) {

            if (Character.isUpperCase(str.charAt(i))) {
                upperCase++;

            }
        }

        System.out.println("The number of uppercase letters is " + upperCase);

    }

}

