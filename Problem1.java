/**
 * Time Complexity : O(n)
 * Space Complexity : O(n)
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
    public boolean isValidBST(TreeNode root) {
        
       return helper(root,null,null);     
    }
    
    public boolean helper(TreeNode node, Integer min, Integer max)
    {
        if(node == null) return true;
        
        int val = node.val;
        if(min!=null && val <=min) return false;
        if(max !=null && val >= max) return false;
        
        return helper(node.left,min,val) && helper(node.right,val,max);
    }
}