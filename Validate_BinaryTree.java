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
        prev = null;
        isValid = true;
        helper(root);
        return isValid;
    }
    public void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        helper(root.left);
        if(prev != null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        prev = root;
        helper(root.right);
    }
}