package ch_23;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 23.6 (Check order) Write the following overloaded methods that check whether an
 * array is ordered in ascending order or descending order. By default, the method
 * checks ascending order. To check descending order, pass false to the ascending
 * argument in the method.
 * public static boolean ordered(int[] list)
 * public static boolean ordered(int[] list, boolean ascending)
 * public static boolean ordered(double[] list)
 * public static boolean ordered
 * (double[] list, boolean ascending)
 * public static <E extends Comparable<E>>
 * boolean ordered(E[] list)
 * public static <E extends Comparable<E>> boolean ordered
 * (E[] list, boolean ascending)
 * public static <E> boolean ordered(E[] list, Comparator<? super E> comparator)
 * public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending)
 */
public class Exercise23_06 {
    /**
     * Test Driver method
     */
    public static void main(String[] args) {
        /* Test int[] */
        int[] listAsc = {1, 2, 3, 4, 7, 9, 11, 27};
        int[] listDesc = {27, 26, 23, 14, 11, 9, 6, 3, 2, 1};
        System.out.print("listAsc = ");
        System.out.print(Arrays.toString(listAsc));
        System.out.println();
        System.out.print("listDesc = ");
        System.out.print(Arrays.toString(listDesc));
        System.out.println();
        System.out.println("listAsc, is ascending?: " + ordered(listAsc));
        System.out.println("listDesc, is descending? " + ordered(listDesc, false));
        System.out.println("listDesc, is ascending?: " + ordered(listDesc));
        System.out.println("listAsc, is descending? " + ordered(listAsc, false));
        /* Test double[] */
        double[] listAscDoubles = {1.3, 2.1, 3.2, 3.4, 3.7, 3.9, 11.21, 27.54};
        double[] listDescDoubles = {27.6, 26.1, 23.3, 14.3, 11.54, 3.9, 3.6, 3.3, 3.2, 3.1};
        System.out.print("listAscDoubles = ");
        System.out.print(Arrays.toString(listAscDoubles));
        System.out.println();
        System.out.print("listDescDoubles = ");
        System.out.print(Arrays.toString(listDescDoubles));
        System.out.println();
        System.out.println("listAscDoubles, is ascending?: " + ordered(listAscDoubles));
        System.out.println("listDescDoubles, is descending? " + ordered(listDescDoubles, false));
        System.out.println("listDescDoubles, is ascending?: " + ordered(listDescDoubles));
        System.out.println("listAscDoubles, is descending? " + ordered(listAscDoubles, false));
        /* Test E[] where E implements Comparable */
        Integer[] listAscInteger = {1, 2, 3, 4, 7, 9, 11, 27};
        Integer[] listDescInteger = {27, 26, 23, 14, 11, 9, 6, 3, 2, 1};
        System.out.print("listAscInteger = ");
        System.out.print(Arrays.toString(listAscInteger));
        System.out.println();
        System.out.print("listDescInteger = ");
        System.out.print(Arrays.toString(listDescInteger));
        System.out.println();
        System.out.println("listAscInteger, is ascending?: " + ordered(listAscInteger));
        System.out.println("listDescInteger, is descending? " + ordered(listDescInteger, false));
        System.out.println("listDescInteger, is ascending?: " + ordered(listDescInteger));
        System.out.println("listAscInteger, is descending? " + ordered(listAscInteger, false));

        /* Test E[] using Comparator */
        Integer[] listAscWithComparator = {1, 2, 3, 4, 7, 9, 11, 27};
        Integer[] listDescWithComparator = {27, 26, 23, 14, 11, 9, 6, 3, 2, 1};
        System.out.print("listAscWithComparator = ");
        System.out.print(Arrays.toString(listAscWithComparator));
        System.out.println();
        System.out.print("listDescWithComparator = ");
        System.out.print(Arrays.toString(listDescWithComparator));
        System.out.println();
        System.out.println("listAscWithComparator, is ascending?: " + ordered(listAscWithComparator,
                (o1, o2) -> {
                    if (o1 > o2) return 1;
                    if (o1 < o2) return -1;
                    return 0;
                }));
        System.out.println("listDescWithComparator, is descending? " + ordered(listDescWithComparator, (o1, o2) -> {
            if (o1 > o2) return 1;
            if (o1 < o2) return -1;
            return 0;
        }, false));
        System.out.println("listDescWithComparator, is ascending?: " + ordered(listDescWithComparator, (o1, o2) -> {
            if (o1 > o2) return 1;
            if (o1 < o2) return -1;
            return 0;
        }));
        System.out.println("listAscWithComparator, is descending? " + ordered(listAscWithComparator, (o1, o2) -> {
            if (o1 > o2) return 1;
            if (o1 < o2) return -1;
            return 0;
        }, false));

    }

    public static boolean ordered(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) return false;
        }
        return true;
    }

    public static boolean ordered(int[] list,
                                  boolean ascending) {
        if (!ascending) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] < list[i + 1]) return false;
            }
            return true;
        }
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) return false;
        }
        return true;
    }

    public static boolean ordered(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) return false;
        }
        return true;
    }

    public static boolean ordered(double[] list,
                                  boolean ascending) {
        if (!ascending) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] < list[i + 1]) return false;
            }
            return true;
        }
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean ordered(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].compareTo(list[i + 1]) > 0) return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean ordered(
            E[] list,
            boolean ascending) {
        if (!ascending) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i + 1]) < 0) return false;
            }
            return true;
        }

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].compareTo(list[i + 1]) > 0) return false;
        }
        return true;
    }

    public static <E> boolean ordered(E[] list,
                                      Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            if (comparator.compare(list[i], list[i + 1]) > 0) return false;
        }
        return true;
    }

    public static <E> boolean ordered(E[] list,
                                      Comparator<? super E> comparator,
                                      boolean ascending) {
        if (!ascending) {
            for (int i = 0; i < list.length - 1; i++) {
                if (comparator.compare(list[i], list[i + 1]) < 0) return false;
            }
            return true;
        }

        for (int i = 0; i < list.length - 1; i++) {
            if (comparator.compare(list[i], list[i + 1]) > 0) return false;
        }
        return true;
    }
}
