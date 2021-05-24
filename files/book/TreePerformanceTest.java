public class TreePerformanceTest {
  public static void main(String[] args) {
    final int TEST_SIZE = 500000; // Tree size used in the test

    // Create an AVL tree
    Tree<Integer> tree1 = new AVLTree<Integer>();
    System.out.println("AVL tree time: " +
      getTime(tree1, TEST_SIZE) + " milliseconds");

    // Create a 2-4 tree
    Tree<Integer> tree2 = new Tree24<Integer>();
    System.out.println("2-4 tree time: "
      + getTime(tree2, TEST_SIZE) + " milliseconds");

    // Create a red-black tree
    Tree<Integer> tree3 = new RBTree<Integer>();
    System.out.println("RB tree time: "
      + getTime(tree3, TEST_SIZE) + " milliseconds");
  }

  public static long getTime(Tree<Integer> tree, int testSize) {
    long startTime = System.currentTimeMillis(); // Start time

    // Create a list to store distinct integers
    java.util.List<Integer> list = new java.util.ArrayList<Integer>();
    for (int i = 0; i < testSize; i++)
      list.add(i);

    java.util.Collections.shuffle(list); // Shuffle the list

    // Insert elements in the list to the tree
    for (int i = 0; i < testSize; i++)
      tree.insert(list.get(i));

    java.util.Collections.shuffle(list); // Shuffle the list

    // Delete elements in the list from the tree
    for (int i = 0; i < testSize; i++)
      tree.delete(list.get(i));

    // Return elapse time
    return System.currentTimeMillis() - startTime;
  }
}
