package ch_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 20.10 (Perform set operations on priority queues) Create two priority queues,
 * {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and
 * {"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their
 * union, difference, and intersection.
 */
public class Exercise20_10 {
    private static String[] l1 = new String[]{"George", "Jim", "John", "Blake", "Kevin", "Michael"};
    private static String[] l2 = new String[]{"George", "Katie", "Kevin", "Michelle", "Ryan"};


    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>(Arrays.asList(l1));
        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(Arrays.asList(l2));

        HashSet<String> union = new HashSet<>(priorityQueue1);
        union.addAll(priorityQueue2);
        System.out.println("Union: " + union);

        PriorityQueue<String> difference = new PriorityQueue<>(priorityQueue1);
        difference.removeAll(priorityQueue2);
        System.out.println("Difference: " + difference);

        PriorityQueue<String> intersection = new PriorityQueue<>(priorityQueue1);
        intersection.retainAll(priorityQueue2);
        System.out.println("Intersection: " + intersection);
    }
}
