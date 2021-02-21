package ch_10.exercise10_28;

import java.util.Arrays;

/**
 * **10.28 (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following methods
 * (name the new class MyStringBuilder2):
 * public MyStringBuilder2();
 * public MyStringBuilder2(char[] chars);
 * public MyStringBuilder2(String s);
 * public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);
 * public MyStringBuilder2 reverse();
 * public MyStringBuilder2 substring(int begin);
 * public MyStringBuilder2 toUpperCase();
 */
public final class MyStringBuilder2 {

    char[] values;

    public MyStringBuilder2() {
        this("".toCharArray());
    }

    public MyStringBuilder2(char[] chars) {
        this.values = chars;
    }

    public MyStringBuilder2(String s) {
        this(s.toCharArray());
    }


    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        char[] nuVals = new char[s.values.length + offset];
        System.arraycopy(this.values, 0, nuVals, 0, offset);
        System.arraycopy(s.values, 0, nuVals, offset, s.values.length);
        this.values = nuVals;

        return this;
    }


    public MyStringBuilder2 reverse() {
        char[] nuVals = new char[values.length];
        for (int i = values.length - 1, j = 0; i >= 0; i--, j++) {
            nuVals[j] = values[i];
        }
        this.values = nuVals;
        return this;

    }

    public MyStringBuilder2 substring(int begin) {
        String s = "";
        for (int i = begin; i < values.length; i++) {
            s += values[i];
        }
        return new MyStringBuilder2(s);

    }

    public MyStringBuilder2 toUpperCase() {
        String s = String.valueOf(values);
        String UC = s.toUpperCase();
        values = Arrays.copyOf(UC.toCharArray(), values.length);
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(values);
    }
}

