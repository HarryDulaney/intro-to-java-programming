package ch_02;

/*
2.11 (Population projection) Rewrite Programming Exercise 1.11 to prompt the user
to enter the number of years and displays the population after the number of years.
Use the hint in Programming Exercise 1.11 for this program. The population
should be cast into an integer.
*/

import java.util.Scanner;

public class Exercise0211 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of years: ");
        int numYears = input.nextInt();

        int currentPopulation = 312_032_486;
        double daysInYear = 365.00;
        double secInYear = daysInYear * 24 * 60 * 60;
        double birthsPerYear = 7 / 60.0 * secInYear;
        System.out.println(birthsPerYear);
        double deathsPerYear = 13 / 60.0 * secInYear;
        double imigrationPerYear = 45 / 60.0 * secInYear;
        System.out.println(deathsPerYear);
        System.out.println(imigrationPerYear);

        double changePerYear = imigrationPerYear + birthsPerYear - deathsPerYear;
        double totalPopAfterYears = changePerYear * numYears;
        int result = (int) (totalPopAfterYears + currentPopulation);
        System.out.println("The population in " + numYears + " years will be " + result);
        System.out.println("Since the change per year is " + (int)(changePerYear));
    }
}
