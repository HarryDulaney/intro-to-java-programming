package ch_25.exercise25_02;

import ch_25.exercise25_01.BST;

public class Exercise25_02 {

    public static void main(String[] args) {
        ch_25.exercise25_01.BST<Integer> test = new BST<>();
        test.insert(2);
        test.insert(4);
        test.insert(7);
        test.insert(5);
        test.insert(8);
        test.insert(3);
        test.insert(6);
        test.insert(9);

        System.out.println("The height of the Binary Search Tree is " + test.height());
    }
}
