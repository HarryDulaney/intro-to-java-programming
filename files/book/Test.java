import java.util.Scanner; 

public class Test {
  public static void main(String[] args) throws Exception {
    // Create a File instance
    java.io.File file = new java.io.File("temp.txt");

    try (
      // Create a Scanner for the file
      Scanner input = new Scanner(file);
    ) {
      // Read data from a file
      while (input.hasNext()) {
        int score = input.nextInt();
        System.out.println(score);
      }
    }
  }
}