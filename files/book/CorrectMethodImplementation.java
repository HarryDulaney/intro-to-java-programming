public class CorrectMethodImplementation {
  public static void main(String[] args) {
    System.out.printf("%15s%15s\n", "n", "m(n)");
    System.out.println("-------------------------------------------");
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%15d%15.2f\n", i, m(i));
    }
  }

  public static double m(int n) {
    double result = 0;
    for (int i = 1; i <= n; i++) {
      result += (2 * i + 1.0) / (3 * i - 2);
    }
    return result;
  }
}
