package ch_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 11.7 (Shuffle ArrayList) Write the following method that shuffles the elements in
 * an ArrayList of integers.
 * public static void shuffle(ArrayList<Integer> list)
 */
public class Exercise11_07 {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            test.add((int) (1 + Math.random() * 99));
        }
        System.out.println("Initial List = " + test.toString());
        ArrayList<Integer> initialList = new ArrayList<>();
        initialList.addAll(test);

        shuffle(test);

        System.out.println("Shuffled List = " + test.toString());

        System.out.println("TEST: Values in shuffled list = values in initial list = " + runTest(test, initialList));
    }

    private static String runTest(ArrayList<Integer> test, ArrayList<Integer> initialList) {
        for (Integer integer : test) {
            if (!initialList.contains(integer)) {
                return "False";
            }
        }
        return "True";
    }

    public static void shuffle(ArrayList<Integer> list) {
        int upperBound = list.size() - 1;
        Random random = new Random();
        int shuffles = 0;
        Integer i = list.remove(random.nextInt(upperBound));
        while (shuffles++ < 100) {
            i = list.set(random.nextInt(upperBound), i);
        }
        list.add(upperBound, i);
    }
}
