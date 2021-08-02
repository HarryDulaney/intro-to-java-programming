package ch_12.exercise12_08;

/**
 * Define a custom exception called HexFormatException.
 */
public class HexFormatException extends NumberFormatException {
    public HexFormatException(String hex) {
        super("Invalid Hex String: " + hex);
    }
}
