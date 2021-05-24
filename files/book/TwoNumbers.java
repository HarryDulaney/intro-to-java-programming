public class TwoNumbers {
  private int number1;
  private int number2;

  /** Create new random numbers with number1 >= number2 */
  public void setNewNumbers() {
    // Generate two random single-digit integers
    number1 = (int)(Math.random() * 100);
    number2 = (int)(Math.random() * 100);

    // If number1 < number2, swap number1 with number2
    if (number1 < number2) {
      int temp = number1;
      number1 = number2;
      number2 = temp;
    }
  }

  /** Return the first number */
  public int getNumber1() {
    return number1;
  }

  /** Return the second number */
  public int getNumber2() {
    return number2;
  }
}
