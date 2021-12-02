package ch_06;

/**
 * **6.25 (Convert milliseconds to hours, minutes, and seconds) Write a method that converts milliseconds to hours, minutes, and seconds using the following header:
 * public static String convertMillis(long millis)
 * The method returns a string as hours:minutes:seconds. For example,
 * convertMillis(5500)returns a string 0:0:5, convertMillis(100000)returns
 * a string 0:1:40, and convertMillis(555550000) returns a string 154:19:10.
 */
public class Exercise06_25 {
    public static void main(String[] args) {
        System.out.println(convertMillis(5500));
        System.out.println(convertMillis(100000));
        System.out.println(convertMillis(555550000));

    }

    public static String convertMillis(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return hours + ":" + (minutes % 60) + ":" + (seconds % 60);
    }
}
