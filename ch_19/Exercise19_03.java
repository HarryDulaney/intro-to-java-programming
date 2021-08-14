package ch_19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19.3 (Distinct elements in ArrayList) Write the following method that returns a new
 * ArrayList.
 * <p>
 * The new list contains the non-duplicate elements from the original list. <br>
 * {@code public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) }
 */
public class Exercise19_03 {

    public static void main(String[] args) {
        //Test the method
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("party", "Tomorrow", "Friday", "cereal", "14", "real",
                "pizza", "party", "Friday", "Thursday", "weekends", "14", "party"));
        System.out.println(removeDuplicates(testList));
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        if (list.size() == 0 || list.size() == 1) {
            return list;
        }
        ArrayList<E> filteredList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!filteredList.contains(list.get(i))) {
                filteredList.add(list.get(i));
            }
        }
        return filteredList;
    }
}
