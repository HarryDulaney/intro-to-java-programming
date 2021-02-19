package ch_10.exercise10_22;

/**
 * **10.22 (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new
 * class MyString1):
 * public MyString1(char[] chars);
 * public char charAt(int index);
 * public int length();
 * public MyString1 substring(int begin, int end);
 * public MyString1 toLowerCase();
 * public boolean equals(MyString1 s);
 * public static MyString1 valueOf(int i);
 */
public class MyString1 {
    char[] chars;

    public MyString1(char[] chars) {
        this.chars = chars;
    }

    public char charAt(int index) {
        if (chars != null && chars.length > index) {
            return chars[index];
        }
        return ' ';
    }

    public int length() {
        if (chars != null) {
            return chars.length;
        }
        return 0;
    }

    public MyString1 substring(int begin, int end) {
        char[] resChars = new char[end - begin];
        if (this.chars != null && chars.length > end) {
            for (int i = begin, resIdx = 0; i < end; i++, resIdx++) {
                resChars[resIdx] = chars[i];
            }
            return new MyString1(resChars);
        }
        return null;
    }

    public MyString1 toLowerCase() {
        if (this.chars != null) {
            char[] resChars = new char[chars.length];
            for (int i = 0; i < resChars.length; i++) {
                resChars[i] = Character.toLowerCase(chars[i]);
            }
            return new MyString1(resChars);
        }
        return null;
    }

    public boolean equals(MyString1 s) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != s.chars[i]) {
                return false;
            }
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        CharSequence temp = i + "";
        return new MyString1(new char[]{temp.charAt(0)});
    }
}
