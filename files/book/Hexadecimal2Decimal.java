import java.util.Scanner;

public class Hexadecimal2Decimal {
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter a string
    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();
    
    int decimalValue = 0;
    for (int i = 0; i < hex.length(); i++) {
      int decimal = 0;
      if (hex.charAt(i) <= 'F' && hex.charAt(i) >= 'A')
        decimal = hex.charAt(i) - 'A' + 10;
      else if (Character.isDigit(hex.charAt(i)))
        decimal = hex.charAt(i) - '0';
      else {
        System.out.println("Wrong input");
        System.exit(1);
      }
      
      decimalValue = decimalValue * 16 + decimal;
    }


    System.out.println("The decimal value for hex number "
      + hex + " is " + decimalValue);
  }

  public static int hexCharToDecimal(char ch) {
    if (ch >= 'A' && ch <= 'F')
      return 10 + ch - 'A';
    else // ch is '0', '1', ..., or '9'
      return ch - '0';
  }
}
