package ch_01;

/**
 * (Population projection)
 * <p>
 * One birth every 7 seconds
 * One death every 13 seconds
 * One new immigrant every 45 seconds
 * Write a program to display the population for each of
 * the next five years.
 * Current population is 312,032,486 and a year is 365 days.
 */
public class Exercise01_11 {
    public static void main(String[] args) {


        double birthInseconds = 7.0;
        double deathInseconds = 13.0;
        double immigrationInseconds = 45.0;

        double birthsPeryear = changeToyears(birthInseconds);
        double deathsPeryear = changeToyears(deathInseconds);
        double immigratePeryear = changeToyears(immigrationInseconds);

        double currentPopulation = 312_032_486;

        for (int i = 1; i <= 5; i++) {
            currentPopulation += birthsPeryear - deathsPeryear + immigratePeryear;

            System.out.print("The population in year " + i + " will be ");
            System.out.printf("%1.0f", currentPopulation);   //To prevent displaying in scientific notation
            System.out.println();
        }

    }

    public static double changeToyears(double valueInseconds) {

        double secondsInyear = 60 * 60 * 24 * 365;

        double amountPeryear = secondsInyear / valueInseconds;

        return amountPeryear;
    }

}
