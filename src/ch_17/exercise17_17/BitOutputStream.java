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
    private byte aByte;
    private FileOutputStream fileOutputStream;
    private int posCounter;
    private File file;

    public BitOutputStream(File file) throws FileNotFoundException {
        this.file = file;
        fileOutputStream = new FileOutputStream(file);
        posCounter = 0;
        aByte = 0b00000000;
    }

    void handleByteCapacity() {
        if (posCounter == 7) { // aByte is full
            try {
                System.out.println("aByte is full, writing to FileOutputStream: " + Integer.toBinaryString(aByte));
                fileOutputStream.write(aByte); // Write to OutputStream
                aByte = 0; // Reset aByte to zero
                posCounter = 0; // Reset capacity counter to zero
            } catch (IOException ioException) {
                System.out.println("Error: internal fileOutputStream through exception. Please check you are using " +
                        "correct 'file' parameter.");
                ioException.printStackTrace();
            }
        }

    }

    public void writeBit(char bit) {
        if (bit != '0' && bit != '1') {
            throw new IllegalArgumentException("writeBit method only excepts char parameters of '0' or '1' ");
        } else {
            handleByteCapacity(); // Check if aByte is full (when posCounter is 8), if so, write to file and reset aByte
            aByte = (byte) (aByte << 1); // Shift over bit values to left by one. For Example: (00001111 << 1) = 00011110
            if (bit == '1') { // If bit is '1' perform logic to change right-most 0 to 1
                aByte = (byte) (aByte | 0b00000001); // Use bit masking to turn the last bit on.
            }
            // Print the aByte result formatted as a String for clarity
            System.out.println("bit is " + bit + " -> aByte is " + Integer.toBinaryString(aByte));
            posCounter += 1;

        }


    }

    public void writeBit(String bit) {
        char[] bits = bit.toCharArray();
        for (char b : bits) {
            writeBit(b);
        }

    }

    @Override
    public void close() throws IOException {
        if (posCounter != 0) {
            while (posCounter != 8) {
                aByte = (byte) (aByte << 1);
                posCounter++;
            }
            System.out.println("Filling rest of aByte with zeros, writing to FileOutputStream:  " + Integer.toBinaryString(aByte));
            fileOutputStream.write(aByte);
        }

        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
