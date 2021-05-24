import java.util.Scanner;

public class LottoNumbers {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    boolean[] isCovered = new boolean[99]; // default false

    // Read all numbers and mark corresponding element covered
    int number = input.nextInt();
    while (number != 0) {
      isCovered[number - 1] = true;
      number = input.nextInt();
    }

    // Check if all covered
    boolean allCovered = true; // Assume all covered
    for (int i = 0; i < 99; i++) 
      if (!isCovered[i]) {
        allCovered = false; // Find one number is not covered
        break;
      } 

    // Display result
    if (allCovered)
      System.out.println("The tickets cover all numbers");
    else
      System.out.println("The tickets don’t cover all numbers");
  } 
}