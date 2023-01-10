// Time Complexity : O(N) in the worst case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class ValidateBinarySearchTree {
    boolean leftSubFlag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        leftSubFlag = true;
        helper(root);
        return leftSubFlag;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (leftSubFlag) {
            helper(root.left);
        }
        if (prev != null && prev.val >= root.val) {
            leftSubFlag = false;
            return;
        }
        prev = root;
        if (leftSubFlag) {
            helper(root.right);
        }
    }
}