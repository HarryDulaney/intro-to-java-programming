package ch_19.exercise19_11;

/**
 * 19.11 (ComplexMatrix) Use the {@link ch_13.exercise13_17.Complex Complex} class,
 * introduced in {@link ch_13.exercise13_17.Exercise13_17 Programming Exercise13_17}
 * to develop the {@link ComplexMatrix} class for
 * performing matrix operations involving complex numbers.
 * <p>
 * The ComplexMatrix class should extend the
 * {@link GenericMatrix} class and implement the add, multiple, and zero methods.
 * <p>
 * You need to modify GenericMatrix and replace every occurrence of Number by
 * Object, because Complex is not a subtype of Number.
 * <p>
 * Write a test program that creates the following two matrices and displays the result of addition and
 * multiplication of the matrices by invoking the printResult method.
 * <p>
 * <p>
 * 1/5 1/6 1/7      1/6 1/7 1/8
 * 2/5 1/3 2/7      1/3 2/7 1/4
 * 3/5 1/2 3/7      1/2 3/7 3/8
 */
public class Exercise19_11 {
    // Test Program
    public static void main(String[] args) {
        ComplexMatrix complexMatrix = new ComplexMatrix();
        Complex[][] m1 = new Complex[][]{
                {new Complex(1, 5), new Complex(1, 6), new Complex(1, 7)},
                {new Complex(2, 5), new Complex(1, 3), new Complex(2, 7)},
                {new Complex(3, 5), new Complex(1, 2), new Complex(3, 7)}
        };

        Complex[][] m2 = new Complex[][]{
                {new Complex(1, 6), new Complex(1, 7), new Complex(1, 8)},
                {new Complex(1, 3), new Complex(2, 7), new Complex(1, 4)},
                {new Complex(1, 2), new Complex(3, 7), new Complex(3, 8)}
        };

        Complex[][] additionResult = complexMatrix.addMatrix(m1, m2);
        ComplexMatrix.printResult(m1, m2, additionResult, '+');

        Complex[][] multipliedResult = complexMatrix.multiplyMatrix(m1, m2);
        ComplexMatrix.printResult(m1, m2, multipliedResult, '*');


    }

}
