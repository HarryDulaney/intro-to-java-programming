package ch_04;

import java.util.*;

/**
 * *4.7 (Corner point coordinates) Suppose a pentagon is centered at (0, 0) with one point
 * at the 0 o’clock position, as shown in Figure 4.7c. Write a program that prompts
 * the user to enter the radius of the bounding circle of a pentagon and displays the
 * coordinates of the five corner points on the pentagon. Here is a sample run:
 * Enter the radius of the bounding circle: 100
 * The coordinates of five points on the pentagon are
 * (95.1057, 30.9017)
 * (0.000132679, 100)
 * (-95.1056, 30.9019)
 * (-58.7788, -80.9015)
 * (58.7782, -80.902)
 */
public class Exercise04_07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the radius of the bounding circle: ");
        double radius = in.nextDouble();
        double angleIncrement = Math.toRadians(360 / 5.0); // Divide by number of points

        // Find angle with 0,0 for five points on the the bounding circle
        double p1Angle = angleIncrement;
        double p2Angle = angleIncrement * 2;
        double p3Angle = angleIncrement * 3;
        double p4Angle = angleIncrement * 4;
        double p5Angle = angleIncrement * 5;

        System.out.printf("(%.4f, %.4f)\n", radius * Math.sin(p1Angle), radius * Math.cos(p1Angle));
        System.out.printf("(%.4f, %.4f)\n", radius * Math.sin(p2Angle), radius * Math.cos(p2Angle));
        System.out.printf("(%.4f, %.4f)\n", radius * Math.sin(p3Angle), radius * Math.cos(p3Angle));
        System.out.printf("(%.4f, %.4f)\n", radius * Math.sin(p4Angle), radius * Math.cos(p4Angle));
        System.out.printf("(%.4f, %.4f)\n", radius * Math.sin(p5Angle), radius * Math.cos(p5Angle));

        in.close();


    }
}