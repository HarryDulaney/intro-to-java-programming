package ch_12;

/**
 * 12.6 (NumberFormatException) Listing 6.8 implements the hex2Dec(String
 * hexString) method, which converts a hex string into a decimal number.
 * Implement the hex2Dec method to throw a NumberFormatException if the
 * string is not a hex string.
 */
public class Exercise12_06 {
    public static void main(String[] args) {
        String hex1 = "AF71Z";
        String hex2 = "AB8C";
        try { //Try block is optional because NumberFormatException is child of RuntimeException (UnChecked Exception)
            System.out.println("The decimal value for hex1 number "
                    + hex1 + " is " + Hex2Dec.hexToDecimal(hex1.toUpperCase()));
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

        try {
            System.out.println("The decimal value for hex2 number "
                    + hex2 + " is " + Hex2Dec.hexToDecimal(hex2.toUpperCase()));
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }
}

class Hex2Dec {

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;

        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if (checkHexChar(hexChar)) {
                decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
            } else {
                throw new NumberFormatException(hex);
            }

        }
        return decimalValue;
    }

    static boolean checkHexChar(char ch) {
        return ch >= '0' && ch <= 'F';
    }

    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else { // ch is '0', '1', ..., or '9'
            return ch - '0';
        }
    }
}