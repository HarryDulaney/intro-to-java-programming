package ch_01;

/**
 * 1.9 (Area and perimeter of a rectangle) Write a program that displays the area and
 * perimeter of a rectangle with the width of 4.5 and height of 7.9 using the
 * following formula: area = width * height
 */
public class Exercise01_09 {
    public static void main(String[] args) {

        double area = 4.5 * 7.9;
        area = Math.round(area * 100);
        area /= 100;

        System.out.println("The area of a rectangle with a width of 4.5 and a height"
                + " of 7.9 is " + area);
        
        System.out.println("Perimeter is " + (2 * (4.5 + 7.9)));
    }
}
