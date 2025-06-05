// Time Complexity O(Hight)
// Space Complexity O(1)
// Runs on LeetCode Yes
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

class ValidateBST {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null){
            return true;
        }

        boolean left = inorder(root.left);
        boolean right = true;

        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        if (left) {
            right = inorder(root.right);
        }
        return left && right;
    }
}