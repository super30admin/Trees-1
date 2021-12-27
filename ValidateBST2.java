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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        prev = null;

        return inorder(root);
    }

    private boolean inorder(TreeNode node){
        if (node == null) return true;

        if (!inorder(node.left)) {
            return false;
        }

        if (prev != null && prev.val >= node.val) return false;
        prev = node;
        return  inorder(node.right);
    }
}