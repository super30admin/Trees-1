//Time Complexity: O(n)
//Space Complexity: O(h) where h is the height of the tree, for the recursion stack
// Leetcode Problem: https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Validates if a given binary tree is a Binary Search Tree (BST).
 * Uses a recursive helper function to check if all nodes follow BST properties.
 * Maintains valid min/max constraints to ensure correctness.
 */

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;

        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left && right;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}