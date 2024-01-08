// Time: O(nodes)
// Space: O(1)
// Ran on leetcode
// No problems in coding

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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        // check own bounds
        if(root.val < min || root.val > max) return false;
        if(root.left != null && root.left.val >= root.val) return false;
        if(root.right != null && root.right.val <= root.val) return false;
        return isValidBST(root.left, min, root.val-1) && isValidBST(root.right, root.val+1, max);
    }
}
