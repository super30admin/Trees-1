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
    Integer min= null;
    Integer max = null;
    
    public boolean isValidBST(TreeNode root) {
        
        // Check the height, maintain the minimum and maximum
        return checkBST(min,max,root);
        
    }
    
    public boolean checkBST(Integer min, Integer max, TreeNode n){
        if(n==null)
            return true;
        if((min != null && n.val <= min) || (max != null && n.val>=max)){
            return false;
        }
        if(!checkBST(min,n.val,n.left)||!checkBST(n.val, max,n.right))
            return false;
        
        return true;
    }
}
