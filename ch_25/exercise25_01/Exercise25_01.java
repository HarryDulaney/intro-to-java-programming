package ch_25.exercise25_01;

/**
 * Exercise09_09 the methods from Exercise 25.1 that we
 * added to the BST
 */
public class Exercise25_01 {

    public static void main(String[] args) {
        BST<Integer> test = new BST<>();
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(6);
        test.insert(7);
        test.insert(8);
        test.insert(12);
        test.insert(14);
        test.insert(19);
        test.insert(11);
        test.insert(13);
        test.insert(15);
        test.insert(21);

        System.out.println("The height of the Binary Search Tree is " + test.height());

        System.out.println("Breadth-First Traversal results in: ");
        test.breadthFirstTraversal();

    }
}
