package ch_20;

import java.util.Scanner;
import java.util.Stack;

/**
 * 20.22 (Nonrecursive Tower of Hanoi) Implement the moveDisks method in Listing
 * 18.8 using a stack instead of using recursion.
 */
public class Exercise20_22 {

    private static final Stack<HanoiMove> STACK = new java.util.Stack<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
    }

    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        STACK.push(new HanoiMove(false, n, fromTower, toTower, auxTower));
        while (!STACK.isEmpty()) {
            HanoiMove hanoiMove = STACK.pop();
            n = hanoiMove.n;
            fromTower = hanoiMove.fromTower;
            toTower = hanoiMove.toTower;
            auxTower = hanoiMove.auxTower;
            if (hanoiMove.isLastInFromTower)
                System.out.println("Move disk " + n + " from " +
                        hanoiMove.fromTower + " to " + hanoiMove.toTower);
            else {
                if (n == 1)
                    System.out.println("Move disk " + n + " from " +
                            hanoiMove.fromTower + " to " + hanoiMove.toTower);
                else {
                    STACK.push(new HanoiMove(false, n - 1, auxTower, toTower, fromTower));
                    STACK.push(new HanoiMove(true, n, fromTower, toTower, auxTower));
                    STACK.push(new HanoiMove(false, n - 1, fromTower, auxTower, toTower));
                }
            }
        }
    }

    public static class HanoiMove {
        boolean isLastInFromTower = false;
        int n;
        char fromTower;
        char toTower;
        char auxTower;

        HanoiMove(boolean isLastInFromTower, int n, char fromTower, char toTower, char auxTower) {
            this.isLastInFromTower = isLastInFromTower;
            this.n = n;
            this.fromTower = fromTower;
            this.toTower = toTower;
            this.auxTower = auxTower;
        }
    }
}