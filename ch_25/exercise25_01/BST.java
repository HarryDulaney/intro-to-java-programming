package ch_25.exercise25_01;

import ch_25.AbstractTree;

import java.util.*;


// *25.1 (Add new methods in BST) Add the following new methods in BST.
/* Displays the nodes in a breadth-first traversal */
// public void breadthFirstTraversal()
/* Returns the height of this binary tree */
// public int height()
public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    /* ************************************************************* Exercise25_01 (Start) ****************************************************************** */
    /* BREADTH-FIRST TRAVERSAL:
     * - Nodes are visited level by level. -
     * -> First, the root is visited.
     * -> Next, all the children of the root from left to right.
     * -> Next, the grandchildren of the root from left to right,
     * and so on. */

    /**
     * Displays the nodes in a breadth-first traversal
     */
    public void breadthFirstTraversal() {
        // If node is null stop the traversal
        if (this.root == null) {
            return;
        }
        //Use a Doubly-linked list to store the nodes
        LinkedList<TreeNode<E>> linkedList = new LinkedList<>();
        // Start with root node
        linkedList.add(this.root);
        // All elements have been traversed when list is empty
        while (!linkedList.isEmpty()) {
            // Retrieve the first element in the list
            TreeNode<E> current = linkedList.element();
            if (current.left != null) {
                // Left
                linkedList.add(current.left);
            }
            if (current.right != null) {
                // Right
                linkedList.add(current.right);
            }
            //Remove the head element in the list
            System.out.print(linkedList.poll() + ", ");
        }
    }

    /**
     * Returns the height of this binary tree
     */
    public int height() {
        return height(root);
    }

    /**
     * @param current the non-null root of current TreeNode<E>
     * @return the height of the longest path from root to leaf node aka height
     */
    int height(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int d1 = height(current.left);
        int d2 = height(current.right);

        if (d1 > d2) {
            return d1 + 1;
        } else {
            return d2 + 1;

        }
    }
    /* ***************************************************************** Exercise25_01 (End) ******************************************************************** */

    /**
     * Create a default binary search tree
     */
    public BST() {
    }

    /**
     * Create a binary search tree from an array of objects
     */
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    /**
     * Return true if the element is in the tree
     */
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                return true; // Element is found
        }
        return false;
    }

    /**
     * Insert element e into the binary search tree
     * Return true if the element is inserted successfully.
     */
    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e); // Create a new root
        } else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; // Element inserted successfully
    }


    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    /**
     * Postorder traversal from the root
     */
    @Override
    public void postorder() {
        postorder(root);
    }

    /**
     * Postorder traversal from a subtree
     */
    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    /**
     * Preorder traversal from the root
     */
    @Override
    public void preorder() {
        preorder(root);
    }

    /**
     * Preorder traversal from a subtree
     */
    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * Remove all elements from the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;

        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    /**
     * Get the number of nodes in the tree
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Returns a path from the root leading to the specified element
     */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list =
                new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return list; // Return an array list of nodes
    }

    /**
     * Delete an element from the binary search tree.
     * Return true if the element is deleted successfully.
     * Return false if the element is not in the tree.
     */
    @Override
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed at by current
        }
        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child.
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent.
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;
            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true; // Element deleted successfully
    }

    /**
     * Obtain an iterator. Use inorder.
     */
    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(root);
        }

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        /**
         * More elements for traversing?
         */
        @Override
        public boolean hasNext() {
            if (current < list.size())
                return true;
            return false;
        }

        /**
         * Get the current element and move to the next
         */
        @Override
        public E next() {
            return list.get(current++);
        }

        /**
         * Remove the current element
         */
        @Override
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }
}