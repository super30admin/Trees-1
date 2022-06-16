// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//98. Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Problem1 {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);

    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        // base
        if (root == null)
            return true;
        if (max != null && root.val >= max)
            return false; // checking if the root values are in the range for each element
        if (min != null && root.val <= min)
            return false;

        boolean left = helper(root.left, min, root.val);// updated max value to root's value for root.left

        boolean right = helper(root.right, root.val, max);// updated min value to root's value for root.right

        return left && right;
    }
}
