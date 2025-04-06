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
 * 
 * TC: O(n)
 * SC: O(1)
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) return true;

        if (minVal != null && minVal >= root.val) return false;
        if (maxVal != null && maxVal <= root.val) return false;

        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}