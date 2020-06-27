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
 
 //Space Complexity=O(h)
// Time Complexity=O(n)
 class Solution {
    TreeNode pre = null; 
    public boolean isValidBST(TreeNode root) {
       return inorder(root);
	    }
    private boolean inorder(TreeNode root)
    {
        if(root == null) return true;
        
        if(inorder(root.left)==false) return false;
        
        if(pre != null && root.val <= pre.val) return false;
        
        pre =root;
        return inorder(root.right);
    }
}