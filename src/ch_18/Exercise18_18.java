package ch_18;

import java.util.Scanner;

/**
 * 18.18 (Tower of Hanoi) Modify Listing 18.8, TowerOfHanoi.java, so that the program
 * finds the number of moves needed to move n disks from tower A to tower B.
 * (Hint: Use a static variable and increment it every time the method is called.)
 */
public class Exercise18_18 {
    private static int moves;

    public static void main(String[] args) {
        moves = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("Total number of moves is: " + moves);
    }


    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        moves++;
        if (n == 1) // Stopping condition (Move the last disk 'n' to complete the tower on the toTower)
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
