
import java.util.Stack;

/**
 * Time Complexity: O(n) where n is nodes of the tree
 * Space Complexity: O(h); height of tree
 * Ran on leetcode? yes
 * Issues faced? No
 * <p>
 * Approach:
 * An inorder traversal of binary search tree is sorted. Utilizing that property,
 * traverse the binary tree and compare it against the previous seen node's value
 */
public class ValidateBinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
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

    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        isValid = true;
        inorder(root);
        return isValid;
    }

    /**
     * Recursive approach
     */
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }

        prev = root;
        inorder(root.right);
    }

    /**
     * Iterative approach
     */
    public boolean isValidBSTIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }

            prev = root;
            root = root.right;
        }
        return true;
    }

    public void checkValidity(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return;

        checkValidity(root.left, min, root.val);
        checkValidity(root.right, root.val, max);
        if (min != null && min >= root.val || (max != null && max <= root.val)) {
            isValid = false;
        }
    }
}
