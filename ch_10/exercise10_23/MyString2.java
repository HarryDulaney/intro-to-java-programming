package ch_10.exercise10_23;

/**
 * public MyString2(String s);
 * public int compare(String s);
 * public MyString2 substring(int begin);
 * public MyString2 toUpperCase();
 * public char[] toChars();
 * public static MyString2 valueOf(boolean b);
 */
public final class MyString2 {
    char[] chars;

    public MyString2(String s) {
        this.chars = s.toCharArray();
    }

    public int compare(String s) {
        int currObjTotal = 0;
        int sTotal = 0;
        if (this.chars.length != s.length()) {
            int commonLength = 0;
            for (int i = 0; i < chars.length && i < s.length(); i++) {
                commonLength = i;
            }
            return this.chars[commonLength] - s.charAt(commonLength);

        }
        for (int i = 0; i < s.length(); i++) {
            currObjTotal += chars[i];
            sTotal += s.charAt(i);
        }
        return currObjTotal - sTotal;
    }

    public MyString2 substring(int begin) {
        String s = "";
        for (int i = begin; i < chars.length; i++) {
            s += chars[i];
        }
        return new MyString2(s);

    }

    public MyString2 toUpperCase() {
        char[] chs = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            chs[i] = Character.toUpperCase(chars[i]);
        }
        return new MyString2(String.copyValueOf(chs));
    }

    public char[] toChars() {
        return chars;
    }

    public static MyString2 valueOf(boolean b) {
        return b ? new MyString2("true") : new MyString2("false");
    }

}
