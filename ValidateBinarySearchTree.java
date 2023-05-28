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
//tc=O(n)
//sc=O(n+h)
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;        
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}