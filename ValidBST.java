/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity: O(2^n)
// Space COmplexity:O(1)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        if(root.val <= min || root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}