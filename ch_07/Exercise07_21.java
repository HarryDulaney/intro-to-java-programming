package ch_07;


import java.util.Arrays;
import java.util.Scanner;

/**
 * **7.21 (Game: bean machine) The bean machine, also known as a quincunx or the Galton
 * box, is a device for statistics experiments named after English scientist Sir
 * Francis Galton. It consists of an upright board with evenly spaced nails (or pegs)
 * in a triangular form, as shown in Figure 7.13.
 * <p>
 * <p>
 * Balls are dropped from the opening of the board. Every time a ball hits a nail, it
 * has a 50% chance of falling to the left or to the right. The piles of balls are accumulated
 * in the slots at the bottom of the board.
 * <p>
 * Write a program that simulates the bean machine. Your program should prompt
 * the user to enter the number of the balls and the number of the slots in the machine.
 * Simulate the falling of each ball by printing its path.
 * <p>
 * (Hint: Create an array named slots. Each element in slots stores the number
 * of balls in a slot. Each ball falls into a slot via a path. The number of Rs in
 * a path is the position of the slot where the ball falls. For example, for the path
 * LRLRLRR, the ball falls into slots[4], and for the path is RRLLLLL, the ball
 * falls into slots[2].)
 *
 * @author Harry D.
 */

public class Exercise07_21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of balls to include in the Galton box experiment: ");
        int balls = in.nextInt();
        System.out.print("\nEnter the number of slots: ");
        int numSlots = in.nextInt();
        int[] slots = new int[numSlots];
        for (int i = 1; i <= balls; i++) { // Run the simulation for each ball
            char[] path = simulateRandomPath(numSlots);
            slots = simulateDrop(path, slots, i);
        }
        System.out.println("Where 1 is equal to a ball in the slot, the slots after all balls are dropped is: ");
        System.out.print(Arrays.toString(slots));
    }

    private static int[] simulateDrop(char[] path, int[] slots, int ballNumber) {
        int resultIdx = 0;
        System.out.println("Ball number " + ballNumber + " falls down path: " + Arrays.toString(path));
        for (char c : path) {
            if (c == 'R') {
                resultIdx++;
            }
        }
        System.out.println("And lands in slot number: " + resultIdx);
        slots[resultIdx - 1] += 1;
        return slots;
    }

    private static char[] simulateRandomPath(int numSlots) {
        char[] result = new char[numSlots];
        for (int i = 0; i < result.length; i++) {
            int random = (int) (Math.random() * 2);
            result[i] = (random == 0) ? 'R' : 'L';
        }
        return result;
    }
}
