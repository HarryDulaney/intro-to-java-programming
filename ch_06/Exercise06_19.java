package ch_06;

/**
 * *6.19 (The MyTriangle class) Create a class named MyTriangle that contains the
 * following two methods:
 * /** Return true if the sum of any two sides is
 * * greater than the third side.
 * public static boolean isValid(
 * double side1,double side2,double side3)
 * /** Return the area of the triangle.
 * public static double area(
 * double side1,double side2,double side3)
 * <p>
 * <p>
 * Write a test program that reads three sides for a triangle and computes the area if
 * the input is valid. Otherwise,it displays that the input is invalid.The formula for
 * computing the area of a triangle is given in Programming Exercise2.19.
 *
 * @author Harry D.
 */
public class Exercise06_19 {
    public static void main(String[] args) {
        double x1 = -1.356;
        double y1 = 1.743;
        double x2 = -1.377;
        double y2 = 1.929;
        double x3 = -1.432;
        double y3 = 1.711;

        double s1 = findSide(x1, y1, x2, y2);
        double s2 = findSide(x2, y2, x3, y3);
        double s3 = findSide(x1, y1, x3, y3);

        if (isValid(s1, s2, s3)) {
            System.out.println("The area of the triangle is: " + area(s1, s2, s3));
        } else {
            System.out.println("The input for sides, is invalid");
        }

    }


    /**
     * Return the area of the triangle.
     */
    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt((s * (s - side1) * (s - side2) * (s - side3)));
    }

    /**
     * Return true if the sum of any two sides is
     * greater than the third side.
     */
    public static boolean isValid(
            double side1, double side2, double side3) {
        if ((side1 + side2) > side3) {
            return false;
        } else if ((side1 + side3) > side2) {
            return false;
        } else if ((side2 + side3) > side1) {
            return false;
        } else {
            return true;
        }
    }

    public static double findSide(double x, double y, double w, double z) {

        return Math.pow(Math.pow(x - w, 2) + Math.pow(y - z, 2), 0.5);
    }
}
