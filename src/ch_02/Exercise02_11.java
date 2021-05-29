package ch_02;

import java.util.Scanner;

/**
 * 2.11 (Population projection) Rewrite Programming {@linkplain ch_01.Exercise01_11} to prompt the user
 * to enter the number of years and displays the population after the number of years.
 * Use the hint in Programming {@linkplain ch_01.Exercise01_11} for this program. The population
 * should be cast into an integer.
 */
public class Exercise02_11 {
    public static void main(String[] args) {
        int currentPopulation = 312_032_486;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of years to display the population growth: ");

        int numberOfYears = input.nextInt();

        double secondsInYear = 365 * 24 * 60 * 60;

        int birthsPerYear = (int) secondsInYear / 7;
        int deathsPerYear = (int) secondsInYear / 13;
        int immigrantsPerYear = (int) secondsInYear / 45;

        for (int i = 1; i <= numberOfYears; i++) {
            currentPopulation += birthsPerYear + immigrantsPerYear - deathsPerYear;
        }
        System.out.println("The population in " + numberOfYears + " is " + currentPopulation);


    }
}
