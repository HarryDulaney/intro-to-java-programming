package ch_19.exercise19_11;

public class ComplexMatrix extends GenericMatrix<Complex> {

    @Override
    protected Complex add(Complex c1, Complex c2) {
        return new Complex(c1.add(c2));
    }

    @Override
    protected Complex multiply(Complex c1, Complex c2) {
        return new Complex(c1.multiply(c2));
    }

    @Override
    protected Complex zero() {
        return new Complex(0.0);
    }

    @Override
    public Complex[][] multiplyMatrix(Complex[][] c1s, Complex[][] c2s) {
        if (c1s[0].length != c2s.length) {
            throw new RuntimeException("The matrices do not have compatible size");
        }

        Complex[][] result = new Complex[c1s.length][c2s[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();
                for (int k = 0; k < c1s[0].length; k++) {
                    result[i][j] = add(result[i][j],
                            multiply(c1s[i][k], c2s[k][j]));
                }
            }
        }
        return result;
    }

    @Override
    public Complex[][] addMatrix(Complex[][] c1s, Complex[][] c2s) {
        if ((c1s.length != c2s.length) || (c1s[0].length != c2s[0].length)) {
            throw new RuntimeException("The matrices do not have the same size");
        }
        Complex[][] result = new Complex[c1s.length][c1s[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(c1s[i][j], c2s[i][j]);
            }
        }
        return result;
    }

    public static void printResult(
            Complex[][] m1, Complex[][] m2, Complex[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++)
                System.out.print(" " + m1[i][j]);
            if (i == m1.length / 2)
                System.out.print(" " + op + " ");
            else
                System.out.print(" ");
            for (int j = 0; j < m2.length; j++)
                System.out.print(" " + m2[i][j]);
            if (i == m1.length / 2)
                System.out.print(" = ");
            else
                System.out.print(" ");
            for (int j = 0; j < m3.length; j++)

                System.out.print(m3[i][j] + " ");
            System.out.println();
        }
    }

}