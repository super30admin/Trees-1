/*
    LC - 98. Validate Binary Search Tree
    TC - O(n)
    SC - O(n)
*/

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
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        prev = null;
        isValid = true;
        inorder(root);
        return isValid;
    }
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}