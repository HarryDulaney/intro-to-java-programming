package ch_07;

import java.util.Scanner;

/**
 * *7.3 (Count occurrence of numbers) Write a program that reads the integers between 1
 * and 100 and counts the occurrences of each. Assume the input ends with 0.
 */
public class Exercise07_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] nums = new int[100];
        int temp;
        int count = 0;
        System.out.print("Enter the integers between 1 and 100: ");
        do {
            temp = input.nextInt();
            nums[count] = temp;
            count++;
        }
        while (temp != 0);

        countOccurrences(nums);
    }

    public static void countOccurrences(int[] list) {
        for (int i = 1; i <= 100; i++) {
            int count = 0;
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] == i)
                    count += 1;
            }
            if (count != 0)
                System.out.printf("%d occurs %d %s%n",
                        i, count, count > 1 ? "times" : "time");
        }
    }
}
