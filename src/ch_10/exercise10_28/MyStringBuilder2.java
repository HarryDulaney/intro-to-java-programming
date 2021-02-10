//package ch_10.exercise10_28;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.function.Function;
//import java.util.function.IntFunction;
//
//public final class MyStringBuilder2 implements Appendable, CharSequence {
//
//    char[] values;
//    int count;
//
//    public MyStringBuilder2() {
//        count = 0;
//        values = new char[16];
//    }
//
//    public MyStringBuilder2(char[] chars) {
//        values = Arrays.copyOf(chars, chars.length + 16);
//
//    }
//
//    public MyStringBuilder2(String s) {
//        this(s.toCharArray());
//    }
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
//
//    public MyStringBuilder2 toUpperCase() {
//        String s = String.valueOf(values);
//        String UC = s.toUpperCase();
//        values = Arrays.copyOf(UC.toCharArray(), values.length);
//        return this;
//    }
//
//    @Override
//    public Appendable append(CharSequence csq) throws IOException {
//
//        return append(csq, values.length, (values.length + csq.length()));
//    }
//
//    @Override
//    public Appendable append(CharSequence csq, int start, int end) throws IOException {
//        if (count == values.length - 1) {
//            values = Arrays.copyOf(values, values.length + 16);
//        }
//        for (int i = start, idx = 0; i < end; i++, idx++) {
//            values[i] = csq.charAt(idx);
//            count++;
//        }
//        return this;
//    }
//
//    @Override
//    public Appendable append(char c) throws IOException {
//        if (count == values.length - 1) {
//            values = Arrays.copyOf(values, values.length + 16);
//        }
//        values[count] = c;
//        count++;
//        return this;
//    }
//
//    @Override
//    public int length() {
//        return count;
//    }
//
//    @Override
//    public char charAt(int index) {
//        if (index < values.length) {
//            return values[index];
//        } else {
//            return '_';
//        }
//    }
//
//    @Override
//    public CharSequence subSequence(int start, int end) {
//        return String.copyValueOf(values, start, end);
//    }
//}
//
