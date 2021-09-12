package ch_25.exercise25_02;

/**
 * 25.2 (Test full binary tree) A full binary tree is a binary tree with the leaves on the
 * same level. Add a method in the {@link BST} class to return true if the tree is a full
 * binary tree. (Hint: The number of nodes in a full binary tree is 2^depth - 1.)
 * /** Returns true if the tree is a full binary tree
 */
public class Exercise25_02 {

    public static void main(String[] args) {
        BST<Integer> test = new BST<>();
        test.insert(50);
        test.insert(40);
        test.insert(60);
        test.insert(30);
        test.insert(42);
        test.insert(54);
        test.insert(62);
        System.out.println(" The Binary Search Tree is " + (test.isFullBST() ? "full." : ""));
    }
}
