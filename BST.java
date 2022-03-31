/*
Time Complexity : O(n) where n is time taken to find whether it's BST or not.
Space Complextiy :  O(h) where h is the height of the tree at max that elements will be stored.
*/

import java.util.*;

class TreeNode {
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

    public class BST {

        public boolean isValidBST(TreeNode root) {
            // base case
            if (root == null)
                return false;
            TreeNode prev = null;

            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || root != null) {

                while (root != null) {

                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if (prev != null && prev.val >= root.val) {

                    return false;
                }
                prev = root;

                root = root.right;

            }

            return true;

        }
    }
}