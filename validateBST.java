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
        if (root == null)
            return true;
        return inorder(root);
    }
    
    public boolean inorder(TreeNode root) {
        // base
        if (root == null) return true;
        // logic
        if (inorder(root.left) == false) 
            return false;
        if (prev != null && prev.val >= root.val) 
            return false;
        
        prev = root;
        
        return inorder(root.right);
    }
}

// Executed