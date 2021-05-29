package ch_02;

import java.util.Scanner;

/**
 * 2.14 (Health application: computing BMI) Body Mass Index (BMI)
 * is a measure of health on weight. It can be calculated by taking
 * your weight in kilograms and dividing by the square of your height in
 * meters. Write a program that prompts the user to enter a weight in
 * pounds and height in inches and displays the BMI.
 * Note that one pound is 0.45359237 kilograms and one inch is 0.0254 meters.
 */
public class Exercise02_14 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your weight in pounds: ");
        double weightInpounds = input.nextDouble();


        System.out.print("Please enter you height in inches: ");
        double heightInInches = input.nextDouble();

        double weightInkilograms = weightInpounds * 0.45359237;

        double heightInmeters = heightInInches * 0.0254;

        double metersFactor = Math.pow(heightInmeters, 2);

        System.out.println("Your BMI is: " + weightInkilograms / metersFactor);
        input.close();
    }

}
