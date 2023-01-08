package ch_16.exercise16_09;


import javafx.scene.paint.Paint;


public class RectangleExt extends javafx.scene.shape.Rectangle {

    private Pt center;
    private Pt bottomRight;
    /*
     * Pt bottomLeft is
     * The X and Y point inherited from javafx.scene.shape.Rectangle
     */


    public RectangleExt() {
        super(0, 0, 1, 1);
        this.center = new Pt();
        this.bottomRight = new Pt();
    }

    public RectangleExt(double centerX, double centerY, double height, double width) {
        super(centerX - width / 2, centerY + height / 2, width, height);
        this.center = new Pt(centerX, centerY);
        resetByCenter(center);
    }

    public RectangleExt(double width, double height, Paint fill) {
        super(width, height, fill);
        this.center = new Pt();
        this.bottomRight = new Pt();
    }


    void setPropertyListeners() {
        widthProperty().addListener((observable, oldValue, newValue) -> {
            sizeChanged();
        });

        heightProperty().addListener((observable, oldValue, newValue) -> {
            sizeChanged();
        });

        xProperty().addListener((observable, oldValue, newValue) -> {
            resetByTopLeft(new Pt(getX(), getY()));
        });

        yProperty().addListener((observable, oldValue, newValue) -> {
            resetByTopLeft(new Pt(getX(), getY()));
        });
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        return (2 * getWidth()) + (2 * getHeight());
    }
    public boolean contains(RectangleExt r) {
        if (r.getArea() > this.getArea()) {
            return false;
        }
        return ((r.getCenter().getX() + r.getWidth() / 2) <= (this.getCenter().getX() + this.getWidth() / 2)) &&
                ((r.getCenter().getX() - r.getWidth() / 2) >= (this.getCenter().getX() - this.getWidth() / 2)) &&
                ((r.getCenter().getY() + r.getHeight() / 2) <= (this.getCenter().getY() + this.getHeight() / 2)) &&
                ((r.getCenter().getY() - r.getHeight() / 2) >= (this.getCenter().getY() - this.getHeight() / 2));
    }


    public boolean overlaps(RectangleExt r) {
        // subtract from the highest number
        double xDistance = (r.getCenter().getX() > getCenter().getX()) ? r.getCenter().getX() - getCenter().getX() : getCenter().getX() - r.getCenter().getX();
        double yDistance = (r.getCenter().getY() > getCenter().getY()) ? r.getCenter().getY() - getCenter().getY() : getCenter().getY() - r.getCenter().getY();
        /* if the r2 overlaps this rectangle this is only valid if the rectangles are parallel */
        return (xDistance <= (getWidth() + r.getWidth()) / 2 && yDistance <= (getHeight() + r.getHeight()) / 2);
    }

    private void resetByCenter(Pt center) {
        setY(center.getY() + getHeight() / 2);
        setX(center.getX() - getWidth() / 2);
        bottomRight = new Pt(center.getX() + getWidth() / 2, center.getY() - getHeight() / 2);
    }

    private void resetByTopLeft(Pt topLeft) {
        center = new Pt(topLeft.getX() + (getWidth() / 2), topLeft.getY() - (getHeight() / 2));
        bottomRight = new Pt(center.getX() + getWidth() / 2, center.getY() - getHeight() / 2);
    }

    private void resetByBottomRight(Pt bottomRight) {
        center = new Pt(bottomRight.getX() - getWidth() / 2, bottomRight.getY() + getHeight() / 2);
        setY(center.getY() + getHeight() / 2);
        setX(center.getX() - getWidth() / 2);
    }

    private void sizeChanged() {
        center = new Pt(bottomRight.getX() - getWidth() / 2, bottomRight.getY() + getHeight() / 2);
        bottomRight = new Pt(center.getX() + getWidth() / 2, center.getY() - getHeight() / 2);
    }

    public void setTopLeft(Pt topLeft) {
        setY(topLeft.getY());
        setX(topLeft.getX());
        resetByTopLeft(topLeft);
    }

    public Pt getCenter() {
        return center;
    }

    public RectangleExt setCenter(Pt center) {
        this.center = center;
        resetByCenter(center);
        return this;
    }

    public Pt getBottomRight() {
        return bottomRight;
    }

    public RectangleExt setBottomRight(Pt bottomRight) {
        this.bottomRight = bottomRight;
        resetByBottomRight(bottomRight);
        return this;
    }

}