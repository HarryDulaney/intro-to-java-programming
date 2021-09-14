package ch_25.exercise25_03;

import ch_25.exercise25_03.*;

import java.util.Scanner;

/**
 * **25.3 (Implement inorder traversal without using recursion) Implement the inorder
 * method in {@link BST} using a stack instead of recursion. Write a test program that
 * prompts the user to enter 10 integers, stores them in a BST, and invokes the
 * inorder method to display the elements.
 */
public class Exercise25_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten integers: ");
        BST<Integer> binarySearchTree = new BST<>();
        String[] line = input.nextLine().split(" ");

        for (String str : line) {
            binarySearchTree.insert(Integer.valueOf(str));
        }
        System.out.println("Root is: " + binarySearchTree.root.element);
        binarySearchTree.inorder();

    }
}
