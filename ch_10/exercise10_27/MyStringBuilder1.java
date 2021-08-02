package ch_10.exercise10_27;

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
        char[] nuValues = new char[oldLength + s.length()];
        System.arraycopy(this.values, 0, nuValues, 0, oldLength);
        System.arraycopy(s.values, 0, nuValues, oldLength, s.length());
        this.values = nuValues;
        return this;
    }

    public MyStringBuilder1 append(int i) {
        int oldLength = values.length;
        String temp = i + "";
        char[] nuVals = new char[values.length + temp.length()];
        char[] integer = temp.toCharArray();
        System.arraycopy(this.values, 0, nuVals, 0, this.values.length);
        System.arraycopy(integer, 0, nuVals, oldLength, integer.length);
        this.values = nuVals;
        return this;

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
        char[] nuVals = new char[end - begin];
        System.arraycopy(this.values, begin, nuVals, 0, nuVals.length);
        this.values = nuVals;
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(values);
    }
}
