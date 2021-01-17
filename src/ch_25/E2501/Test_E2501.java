package ch_25.E2501;

/**
 * Test the methods from Exercise 25.1 that we
 * added to the BST
 */
public class Test_E2501 {

    public static void main(String[] args) {
        BST<Integer> test = new BST<>();
        test.insert(2);
        test.insert(4);
        test.insert(7);
        test.insert(5);
        test.insert(3);
        test.insert(8);
        test.insert(6);
        test.insert(9);

        System.out.println("The height of the Binary Search Tree is " + test.height());

        System.out.println("Breadth-First Traversal results in: ");
        test.breadthFirstTraversal();

    }
}
