package chapter43;

public class FactorialBean {
  private int number;

  /** Return number property */
  public int getNumber() {
    return number;
  }

  /** Set number property */
  public void setNumber(int newValue) {
    number = newValue;
  }

  /** Obtain factorial */
  public long getFactorial() {
    long factorial = 1;
    for (int i = 1; i <= number; i++)
      factorial *= i;
    return factorial;
  }
}
