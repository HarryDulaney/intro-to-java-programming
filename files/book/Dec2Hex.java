import java.util.Scanner;

public class Dec2Hex {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter a decimal integer
    System.out.print("Enter a decimal number: ");
    int decimal = input.nextInt();

    // Convert decimal to hex
    String hex = "";
    
    while (decimal != 0) {
      int hexValue = decimal % 16; 
      
      // Convert a decimal value to a hex digit 
      char hexDigit = (hexValue <= 9 && hexValue >= 0) ?
        (char)(hexValue + '0') : (char)(hexValue - 10 + 'A');
      
      hex = hexDigit + hex;
      decimal = decimal / 16;
    }
    
    System.out.println("The hex number is " + hex);
  }
}
