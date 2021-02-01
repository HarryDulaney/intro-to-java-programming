package ch_09.exercise09_11;

import java.util.Scanner;

public class Exercise09_11 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a, b, c, d, e, f;

        System.out.println("Enter values for a, b, c, d, e, and f now:");

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        d = input.nextDouble();
        e = input.nextDouble();
        f = input.nextDouble();

        LinearEquation tester = new LinearEquation(a, b, c, d, e, f);

        if (tester.isSolvable()) {


            System.out.println("x is " + tester.getX());
            System.out.println("y is " + tester.getY());


        } else {
            System.out.println("The equation has no solution");
        }
        input.close();
    }
}
