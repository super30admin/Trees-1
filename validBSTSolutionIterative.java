// Time Complexity : O(n), As it traverses through all the nodes present in the tree
// Space Complexity : O(h) height of the tree, as we store only left nodes until the end of the tree in the stack, we used a space equal to the height of the tree
// Did this code successfully run on Leetcode : yes

import java.util.*;

public class validBSTSolutionIterative {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode arrayToTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return arrayToTree(array, 0);
    }

    private TreeNode arrayToTree(Integer[] array, int root) {
        if (root >= array.length) {
            return null;
        }
        return new TreeNode(array[root], arrayToTree(array, (root * 2) + 1), arrayToTree(array, (root * 2) + 2));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        // this is outer loop, this traverse through both left and right nodes
        // and pushes all the left nodes into the stack
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            } // once all the left nodes are finished, it comes out of the loop
              // pops each node, one by one and traverse their first right node and then again
              // parses all the left nodes of that right node from above inner while loop
            root = s.pop();
            // while popping, it checks if the prev node is greater than current node value
            // as in BST, they are in ascending order, while doing InOrder Traversal
            // If it is greater, then it means this is not a valid BST
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;// else other wise assign the cuurent to the prev variable and continue
            // once the inner while is done, fetch the immediate right node of top node
            root = root.right;
        }

        return true;
    }

    public static void main(String[] args) {
        validBSTSolutionIterative vbs = new validBSTSolutionIterative();
        Integer[] inputArray = { 5, 1, 4, 3, 6 };
        TreeNode inputBinaryTree = vbs.arrayToTree(inputArray);
        System.out.println("For Input1: " + vbs.isValidBST(inputBinaryTree));

        Integer[] inputArray2 = { 2, 1, 3 };
        TreeNode inputBinaryTree2 = vbs.arrayToTree(inputArray2);
        System.out.println("For Input2: " + vbs.isValidBST(inputBinaryTree2));

    }
}