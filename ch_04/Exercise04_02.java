package ch_04;

import java.util.Scanner;

/**
 * 4.2 (Geometry: great circle distance) The great circle distance is the
 * distance between two points on the surface of a sphere. Let (x1, y1)
 * and (x2, y2) be the geographical latitude and longitude of two points.
 * The great circle distance between the two points can be computed using
 * the following formula:
 * Write a program that prompts the user to enter the latitude and
 * longitude of two points on the earth in degrees and displays its great
 * circle distance. The average earth radius is 6,371.01 km. Note that you
 * need to convert the degrees into radians using the Math.toRadians method
 * since the Java trigonometric methods use radians. The latitude and
 * longitude degrees in the formula are for north and west. Use negative to
 * indicate south and east degrees.
 *
 * @author Harry D.
 */
public class Exercise04_02 {
    public static void main(String[] args) {

        double xOne, xTwo, yOne, yTwo, distance;

        final double radius = 6371.01;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter point 1 (latitude and longitude) in degrees: ");

        xOne = input.nextDouble();
        yOne = input.nextDouble();

        xOne = Math.toRadians(xOne);
        yOne = Math.toRadians(yOne);

        System.out.println("Enter point 2 (latitude and longitude) in degrees: ");

        xTwo = input.nextDouble();
        yTwo = input.nextDouble();

        xTwo = Math.toRadians(xTwo);
        yTwo = Math.toRadians(yTwo);


        distance = radius * (Math.acos((Math.sin(xOne) * Math.sin(xTwo)) +
                (Math.cos(xOne) * Math.cos(xTwo) * Math.cos(yOne - yTwo))));

        System.out.println("The distance between the two points is: " + distance
                + " km");


    }

}
