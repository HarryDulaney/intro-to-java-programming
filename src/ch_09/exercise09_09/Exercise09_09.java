package ch_09.exercise09_09;

public class Exercise09_09 {
    public static void main(String[] args) {

        RegularPolygon polyOne = new RegularPolygon();

        RegularPolygon polyTwo = new RegularPolygon(6, 4);

        RegularPolygon polyThree = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("The perimeter of polygon one is " + polyOne.getPerimeter() + " the "
                + "area of polygon one is " + polyOne.getArea());

        System.out.println("The perimeter of polygon two is " + polyTwo.getPerimeter() + " the "
                + "area of polygon two is " + polyTwo.getArea());

        System.out.println("The perimeter of polygon three is " + polyThree.getPerimeter() + " the "
                + "area of polygon three is " + polyThree.getArea());

    }
}
