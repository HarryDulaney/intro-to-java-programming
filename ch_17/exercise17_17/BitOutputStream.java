package ch_17.exercise17_17;

import java.io.*;

/**
 * (BitOutputStream) Implement a class named BitOutputStream, as shown
 * in Figure 17.22, for writing bits to an output stream. The writeBit(char bit)
 * method stores the bit in a byte variable. When you create a BitOutputStream,
 * the byte is empty. After invoking writeBit('1'), the byte becomes 00000001.
 * After invoking writeBit("0101"), the byte becomes 00010101. The first
 * three bits are not filled yet. When a byte is full, it is sent to the output stream. Now
 * the byte is reset to empty. You must close the stream by invoking the close()
 * method.
 * <p>
 * If the byte is neither empty nor full, the close() method first fills the
 * zeros to make a full 8 bits in the byte, and then outputs the byte and closes the
 * stream.
 * <p>
 * For a hint, see Programming Exercise 5.44.
 * <p>
 * * [BitOutputStream]
 * * ***************************************************************************************
 * * +BitOutputStream(file: File) ---- Creates a BitOutputStream to writes bits to the file.
 * * +writeBit(char bit): void ------ Writes a bit '0' or '1' to the output stream.
 * * +writeBit(String bit): void ----- Writes a string of bits to the output stream.
 * * +close(): void ----- This method must be invoked to close the stream.
 * * ***************************************************************************************
 * * FIGURE 17.22 BitOutputStream outputs a stream of bits to a file.
 */
public class BitOutputStream implements Closeable {
    private int value;
    private FileOutputStream fileOutputStream;
    private int posCounter = 0;
    private File file;

    public BitOutputStream(File file) throws FileNotFoundException {
        this.file = file;
        fileOutputStream = new FileOutputStream(file);
    }

    public void writeBit(char bit) {
        if (isValid(bit)) {
            posCounter++;
            value = value << 1; // Shift over bit values to left by one. For Example: (00001111 << 1) = 00011110
            if (bit == '1') { // If bit is '1' perform logic to change right-most 0 to 1
                value = value | 1; // Use bit masking to turn the last bit on.
            }
            // Check if value is full (when posCounter is 8), if so, write to file and reset aByte
            if (posCounter == 8) { // value is full (Bit at position 8 is always 0 (non-negative))
                try {
                    System.out.println("Byte value is full, writing to FileOutputStream: " + Integer.toBinaryString(value));
                    fileOutputStream.write(value); // Write to OutputStream
                    posCounter = 0; // Reset capacity counter to zero
                    value = 0;
                } catch (IOException ioException) {
                    System.out.println("Error: internal fileOutputStream through exception. Please check you are using " +
                            "correct 'file' parameter.");
                    ioException.printStackTrace();
                }
            }

            // Print the value result formatted as a String for clarity
//            System.out.println("bit is " + bit + " -> value is " + Integer.toBinaryString(aByte));
        } else {
            throw new IllegalArgumentException("writeBit method only excepts char parameters of '0' or '1' ");
        }
    }

    private boolean isValid(char bit) {
        return bit == '0' ||
                bit == '1' ||
                bit == '\n' ||
                bit == '\t';
    }

    public void writeBit(String bit) {
        for (int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    @Override
    public void close() throws IOException {
        if (posCounter > 0) {
            int shift = 8 - posCounter;
            value = value << shift;
            fileOutputStream.write(value);
            System.out.println("Filling rest of the byte value with zeros and writing to FileOutputStream:  " + Integer.toBinaryString(value));
        }
        fileOutputStream.close();
    }

}
