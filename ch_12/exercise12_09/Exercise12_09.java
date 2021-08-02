package ch_12.exercise12_09;

/**
 * 12.9 (BinaryFormatException) Exercise 12.7 implements the bin2Dec method
 * to throw a BinaryFormatException if the string is not a binary string.
 * Define a custom exception called BinaryFormatException. Implement the
 * bin2Dec method to throw a BinaryFormatException if the string is not a
 * binary string.
 */
public class Exercise12_09 {
    public static void main(String[] args) {
        //Test

        String binaryString1 = "1010";
        String binaryString2 = "1014";
        try {

            System.out.println("Binary number: " + binaryString1 + " converted to decimal is " + bin2Dec(binaryString1));
            System.out.println("Binary number: " + binaryString2 + " converted to decimal is " + bin2Dec(binaryString2));

        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException);
        }
    }

    public static int bin2Dec(String binaryString) {
        int decimalValue = 0;
        if (!checkBinaryChars(binaryString)) {
            throw new BinaryFormatException(binaryString);
        }
        char[] binChars = binaryString.toCharArray();

        for (int i = binChars.length - 1, binaryIndex = 0; i >= 0; i--, binaryIndex++) {
            decimalValue += getBinaryValue(binChars[i], binaryIndex);
        }


        return decimalValue;
    }

    static boolean checkBinaryChars(String binaryString) {
        char[] binStrValues = binaryString.toCharArray();
        for (char c : binStrValues) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    static int getBinaryValue(char binaryChar, int index) {
        int weight = (int) Math.pow(2, index);
        if (binaryChar == '1') {
            return weight;
        }
        return 0;
    }

}
