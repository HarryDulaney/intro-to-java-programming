import java.util.Scanner; 

public class PrintPyramid {
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter the number of lines
    System.out.print("Enter the number of lines: ");
    int numberOfLines = input.nextInt();

    if (numberOfLines < 1 || numberOfLines > 15) {
      System.out.println("You must enter a number from 1 to 15");
      System.exit(0);
    }

    // Print lines
    for (int row = 1; row <= numberOfLines; row++) {
      // Print NUMBER_OF_LINES – row) leading spaces
      for (int column = 1; column <= numberOfLines - row; column++)
        System.out.print("   ");

      // Print leading numbers row, row – 1, ..., 1
      for (int num = row; num >= 1; num--)
        System.out.print((num >= 10) ? " " + num : "  " + num);

      // Print ending numbers 2, 3, ..., row – 1, row
      for (int num = 2; num <= row; num++)
        System.out.print((num >= 10) ? " " + num : "  " + num);

      // Start a new line
      System.out.println();
    }
  }
}
