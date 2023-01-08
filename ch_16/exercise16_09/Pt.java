package ch_16.exercise16_09;


public class Pt {
    private double x;
    private double y;

    public Pt() {
        x = 0;
        y = 0;
    }

    public Pt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Pt point) {
        return distance(point.x, point.y);

    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
