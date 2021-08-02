package ch_02;

import java.util.Scanner;

/**
 * 2.15 (Geometry: distance of two points) Write a program that prompts the user to enter
 * two points (x1, y1) and (x2, y2) and displays their distance between them.
 * The formula for computing the distance is sqrt[(x2 - x1)^2 + (y2 - y1)^2)]. Note that
 * you can use Math.pow(a, 0.5) to compute sqrt(a). Sample run:
 * <p>
 * Enter x1 and y1: 1.5 -3.4
 * Enter x2 and y2: 4 5
 * The distance between the two points is 8.764131445842194
 */
public class Exercise02_15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x1 and y1: ");
        double x1, x2, y1, y2;

        x1 = input.nextDouble();
        y1 = input.nextDouble();

        System.out.println("Enter x2 and y2: ");

        x2 = input.nextDouble();
        y2 = input.nextDouble();

        double exs = Math.pow((x2 - x1), 2);
        double whys = Math.pow((y2 - y1), 2);

        double a = Math.pow((exs + whys), 0.5);

        System.out.println("The distance between the two points is " + a);


    }

}
