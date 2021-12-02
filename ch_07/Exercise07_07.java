package ch_07;

/**
 * 7.7 (Count single digits) Write a program that generates 100 random
 * integers between 0 and 9 and displays the count for each number.
 *
 * @author Harry Dulaney
 */
public class Exercise07_07 {
    public static void main(String[] args) {
        int[] counts = new int[10];
        int randomNum = 0;
        for (int i = 0; i < 100; i++) {
            randomNum = (int) (Math.random() * 10);
            counts[randomNum]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.print(counts[i] + " counts of ");
            System.out.println(i);
        }


    }

}
