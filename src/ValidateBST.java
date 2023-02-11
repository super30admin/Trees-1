// Time Complexity : O(N)
// Space Complexity : O(N) (Recursion stack)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/**
 * In BST, root > left && root < right. Apply this check
 * on every node of the tree. Return false if any node violates
 * this rule.
 *
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
