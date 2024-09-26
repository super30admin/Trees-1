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
/*
SC: O(h)
TC: O(n)
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)    return true;
        
        return validateBST(root,null,null);
    }
    
    private boolean validateBST(TreeNode node, Integer low, Integer high){
        
        if(node == null)    return true;
        
        if((low != null && node.val <= low) || 
            (high != null && node.val >= high)){
            return false;
        } 
           
        return validateBST(node.left, low , node.val) && validateBST(node.right, node.val, high);
    }
}
