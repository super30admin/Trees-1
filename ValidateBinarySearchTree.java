//https://leetcode.com/problems/validate-binary-search-tree/
// Time Complexity :O(n) 
// Space Complexity :O(h) h=height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
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
        prev=null;
        isValid=true;
        helper(root);
        return isValid;
    }
    private void helper(TreeNode root)
    {
        if(root==null)
            return;
        
        helper(root.left);
        if(prev!=null && prev.val>=root.val)
        { isValid=false; return;}
            
        prev=root;
        if(isValid)
        helper(root.right);
    }
}