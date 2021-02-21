package ch_10.exercise10_27;

import ch_10.exercise10_22.MyString1;

import java.util.Arrays;

/**
 * **10.27 (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following methods
 * (name the new class MyStringBuilder1):
 * public MyStringBuilder1(String s);
 * public MyStringBuilder1 append(MyStringBuilder1 s);
 * public MyStringBuilder1 append(int i);
 * public int length();
 * public char charAt(int index);
 * public MyStringBuilder1 toLowerCase();
 * public MyStringBuilder1 substring(int begin, int end);
 * public String toString();
 */
public class MyStringBuilder1 {
    char[] values;

    public MyStringBuilder1(String s) {
        values = s.toCharArray();
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        int oldLength = this.values.length;
        this.values = Arrays.copyOf(values, this.values.length + s.values.length);
        for (int i = (oldLength - 1), j = 0; j < s.values.length; i++, j++) {
            this.values[i] = s.values[j];
        }
        return new MyStringBuilder1(String.valueOf(this.values));
    }

    public MyStringBuilder1 append(int i) {
        int oldLength = values.length;
        String temp = i + "";
        if (oldLength < oldLength + 1) {
            values = Arrays.copyOf(values, values.length + temp.length());
        }
        char[] integer = temp.toCharArray();
        for (int x = oldLength - 1, j = 0; j < integer.length; x++, j++) {
            values[x] = integer[j];

        }
        return new MyStringBuilder1(String.valueOf(values));
    }

    public int length() {
        return values.length;
    }

    public char charAt(int index) {
        return values[index];
    }

    public MyStringBuilder1 toLowerCase() {
        char[] nu = new char[this.values.length];
        for (int i = 0; i < nu.length; i++) {
            nu[i] = Character.toLowerCase(this.values[i]);
        }
        return new MyStringBuilder1(String.valueOf(nu));
    }

    public MyStringBuilder1 substring(int begin, int end) {
        return new MyStringBuilder1(String.valueOf(values).substring(begin, end));
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
