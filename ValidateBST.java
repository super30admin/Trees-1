// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
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
class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode root) {
        if (root == null)
            return true;

        boolean l = helper(root.left);

        if (prev != null && root.val <= prev.val)
            return false;
        prev = root;

        boolean r = helper(root.right);

        return l && r;
    }
}