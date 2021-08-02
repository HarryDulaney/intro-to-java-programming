package ch_10.exercise10_23;

import java.util.Arrays;

/**
 * **10.23 (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new class MyString2):
 * public MyString2(String s);
 * public int compare(String s);
 * public MyString2 substring(int begin);
 * public MyString2 toUpperCase();
 * public char[] toChars();
 * public static MyString2 valueOf(boolean b);
 */
public class Exercise10_23 {
    public static void main(String[] args) {
        MyString2 myString21 = new MyString2("Supercalifrajaliscousexpialidocious");
        MyString2 myString22 = new MyString2("abcdefghijklmnopqrstuvwxyz");
        String s = "abcdefghijklmnopqrstuvwxyz";
        MyString2 myString113 = new MyString2("HelloWorldWorldHelloWorld");
        MyString2 myString4 = new MyString2("MILO");
        MyString2 myString5 = new MyString2("SimonAndGarfunkel");
        System.out.println(Arrays.toString(myString4.toUpperCase().chars));
        System.out.println(myString22.compare(s));
        System.out.println(myString21.compare("SomeRandomString"));
        System.out.println(Arrays.toString(myString113.substring(3).chars));
        System.out.println(Arrays.toString(myString5.toChars()));
    }
}
