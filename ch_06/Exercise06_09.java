package ch_06;

/**
 * 6.9 (Conversions between feet and meters) Write a class that contains the following
 * two methods:
 * Convert from feet to meters
 * public static double footToMeter(double foot)
 * /** Convert from meters to feet
 * public static double meterToFoot(double meter)
 * The formula for the conversion is:
 * meter=0.305*foot
 * foot=3.279*meter
 * <p>
 * Write a test program that invokes these methods to display the following tables:
 * <p>
 * Feet Meters | Meters Feet
 * 1.0 0.305 | 20.0 65.574
 * 2.0 0.610 | 25.0 81.967
 * ...
 * 9.0 2.745 | 60.0 196.721
 * 10.0 3.050 | 65.0 213.115
 */
public class Exercise06_09 {
    public static void main(String[] args) {
        System.out.println("Feet                Meters              |            Meters                  Feet");
        System.out.println(
                "___________________________________________________________________________________");
        for (int f = 1, m = 20; f <= 10; f++, m += 5) { // integers are more reliable for consistent looping behavior
            double feet = f; //Cast to double
            double meters = m; //Cast to double
            if (f <= 9) {
                System.out.print(" "); //Leading space
            }
            System.out.printf("%-2.1f                 %.3f", feet, footToMeter(feet));
            System.out.print("              |            ");
            System.out.printf("%2.1f                   %.3f\n", meters, meterToFoot(meters));

        }
    }

    /**
     * Convert from feet to meters
     */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /**
     * Convert from meters to feet
     */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }


}