package ch_12.exercise12_06;

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
