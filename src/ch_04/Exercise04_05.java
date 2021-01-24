package ch_04;

import java.util.*;

public class Exercise04_05 {
    //computes the area of a regular polygon
    public static void main(String[] args) {

        System.out.println("Enter the number of sides of the polygon: ");

        Scanner input = new Scanner(System.in);

        int numSides = input.nextInt();

        System.out.println("Enter the length of the sides: ");

        double lengthSides = input.nextDouble();

        double area = (numSides * lengthSides * lengthSides) / (4 * Math.tan(Math.PI / numSides));

        System.out.println("The area of your polygon is: " + area);


    }
}
