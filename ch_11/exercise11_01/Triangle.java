package ch_11.exercise11_01;


public class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;


    public Triangle() {

        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;

    }

    public Triangle(double newSide1, double newSide2, double newSide3) {

        this.side1 = newSide1;
        this.side2 = newSide2;
        this.side3 = newSide3;

    }

    public double getArea() {
        double s = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

    public double getPerimeter() {

        double p = this.side1 + this.side2 + this.side3;

        return p;

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
