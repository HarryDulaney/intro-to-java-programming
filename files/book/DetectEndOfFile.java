import java.io.*;

public class DetectEndOfFile { 
  public static void main(String[] args) {
    try {
      try (DataOutputStream output = 
        new DataOutputStream(new FileOutputStream("test.dat"))) {
        output.writeDouble(4.5);
        output.writeDouble(43.25);
        output.writeDouble(3.2);
      }
      
      try (DataInputStream input = 
        new DataInputStream(new FileInputStream("test.dat"))) {
        while (true) 
          System.out.println(input.readDouble());
      }
    }
    catch (EOFException ex) {
      System.out.println("All data were read");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
