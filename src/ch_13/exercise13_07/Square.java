package ch_13.exercise13_07;

public class Square extends GeometricObject implements Colorable {

    private double height;

    public Square(double height) {
        this.height = height;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");

    }

    @Override
    public double getArea() {
        return this.height * this.height;
    }

    @Override
    public double getPerimeter() {
        return height * 4;
    }
}
