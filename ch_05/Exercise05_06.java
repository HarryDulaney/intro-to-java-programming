package ch_05;

/**
 * 5.6 (Conversion from miles to kilometers) Write a program that displays the following two tables side by side:
 * Miles Kilometers | Kilometers Miles
 * 1 1.609 | 20 12.430
 * 2 3.218 | 25 15.538
 * ...
 * 9 14.481 | 60 37.290
 * 10 16.090 | 65 40.398
 */
public class Exercise05_06 {
    public static void main(String[] args) {

        final double Kilo_Per_Mile = 1.609;


        System.out.println("Miles       Kilometers  |  Kilometers     Miles");

        for (int i = 1, j = 20; i <= 10 && j <= 65; i++, j += 5) {


            System.out.printf("%-11d%10.3f", i, (i * Kilo_Per_Mile));
            System.out.print("   |   ");
            System.out.printf("%-15d%-6.3f\n", j, (j / Kilo_Per_Mile));


        }
    }
}


