public class TestRationalMatrix {
  public static void main(String[] args) {
    // Create two Rational arrays m1 and m2
    Rational[][] m1 = new Rational[3][3];
    Rational[][] m2 = new Rational[3][3];
    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < m1[0].length; j++) {
        m1[i][j] = new Rational(i + 1, j + 5);
        m2[i][j] = new Rational(i + 1, j + 6);
      }

    // Create an instance of RationalMatrix
    RationalMatrix rationalMatrix = new RationalMatrix();

    System.out.println("\nm1 + m2 is ");
    GenericMatrix.printResult(
      m1, m2, rationalMatrix.addMatrix(m1, m2), '+');

    System.out.println("\nm1 * m2 is ");
    GenericMatrix.printResult(
      m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
  }
}
