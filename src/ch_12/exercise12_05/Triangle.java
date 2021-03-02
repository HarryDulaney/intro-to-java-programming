package ch_12.exercise12_05;

import ch_11.exercise11_01.GeometricObject;

public class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;


    public Triangle() {

        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;

    }

    /**
     * Construct a triangle with the specified sides
     */
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        setSides(side1, side2, side3);
    }

    public double getArea() {
        double s = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

    public double getPerimeter() {

        double p = this.side1 + this.side2 + this.side3;

        return p;

    }

    private void setSides(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 < side3) {
            throw new IllegalTriangleException(side1, side2, side3);
        } else if (side2 + side3 < side1) {
            throw new IllegalTriangleException(side1, side2, side3);
        } else if (side1 + side3 < side2) {
            throw new IllegalTriangleException(side1, side2, side3);
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;

        }

    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 +
                " side3 = " + this.side3;
    }
}

