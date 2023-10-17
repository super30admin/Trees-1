
// Time Complexity :O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope



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
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {    
    this.flag = true;
    inorder(root); 
    return flag;      
    }
    
    private void inorder(TreeNode root){
        //base
        if(root== null) return;   
        //logic
        inorder(root.left);
        //st. pop
        
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        if(flag){
        inorder(root.right);
        }
 
        
    }
    
    
}
