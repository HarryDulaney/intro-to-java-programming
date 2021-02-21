package ch_10.exercise10_28;

import java.util.Arrays;

public final class MyStringBuilder2 {

    char[] values;
    int count;

    public MyStringBuilder2() {
        count = 0;
        values = new char[16];
    }

    public MyStringBuilder2(char[] chars) {
        values = Arrays.copyOf(chars, chars.length + 16);

    }

    public MyStringBuilder2(String s) {
        this(s.toCharArray());
    }
//
//
//    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
//    }
//
//
//    public MyStringBuilder2 reverse() {
//
//    }
//
//    public MyStringBuilder2 substring(int begin) {
//
//    }

    public MyStringBuilder2 toUpperCase() {
        String s = String.valueOf(values);
        String UC = s.toUpperCase();
        values = Arrays.copyOf(UC.toCharArray(), values.length);
        return this;
    }
}

