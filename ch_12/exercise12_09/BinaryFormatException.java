package ch_12.exercise12_09;

/*
 * Define a custom exception called BinaryFormatException.
 */
public class BinaryFormatException extends NumberFormatException {

    public BinaryFormatException(String binaryString) {
        super("Invalid binary string: " + binaryString);
    }
}
