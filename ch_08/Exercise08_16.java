package ch_08;

/*
*8.16 (Sort two-dimensional array) Write a method to sort a two-dimensional array
using the following header:
public static void sort(int m[][])
The method performs a primary sort on rows and a secondary sort on columns.
For example, the following array
{{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}
will be sorted to
{{1, 1},{1, 2},{1, 7},{4, 1},{4, 2},{4, 5}}.
 */

import java.util.Arrays;

public class Exercise08_16 {
    public static void main(String[] args) {
        int[][] testArray = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};

        sort(testArray);


    }

    public static void sort(int m[][]) {

        for (int i = 0; i < m.length - 1; i++) {
            int currentMinRow = m[i][0];
            int currentMinCol = m[i][1];
            int currentMinIndex = i;

            for (int j = i + 1; j < m.length; j++) {
                if (currentMinRow > m[j][0]) {
                    currentMinRow = m[j][0];
                    currentMinCol = m[j][1];
                    currentMinIndex = j;
                } else if (currentMinRow == m[j][0] && currentMinCol > m[j][1]) {
                    currentMinCol = m[j][1];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                m[currentMinIndex][0] = m[i][0];
                m[i][0] = currentMinRow;
                m[currentMinIndex][1] = m[i][1];
                m[i][1] = currentMinCol;

            }


        }

        for (int i = 0; i < m.length; i++) {
            System.out.print(Arrays.toString(m[i]) + " ");
        }

    }
}
