package ch_09.exercise09_13;

/**
 * **9.13 (The Location class) Design a class named Location for locating a maximal
 * value and its location in a two-dimensional array.
 * <p>
 * The class contains public data
 * fields row, column, and maxValue that store the maximal value and its indices
 * in a two-dimensional array with row and column as int types and maxValue as
 * a double type.
 * Write the following method that returns the location of the largest element in a
 * two-dimensional array:
 * public static Location locateLargest(double[][] a)
 * The return value is an instance of Location.
 */
public class Location {

    public double maxValue = Integer.MIN_VALUE;
    public int row;
    public int column;


    public static Location locateLargest(double[][] a) {
        Location location = new Location();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > location.maxValue) {
                    location.maxValue = a[i][j];
                    location.row = i;
                    location.column = j;
                }

            }
        }
        return location;
    }
}
