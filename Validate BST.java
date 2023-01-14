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

 // Time Complexity = O(N)
 // Space Complexity = O(height of recursive tree) 


class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }
    
    private void helper(TreeNode root){
        //base
        if(root == null) return;
        
        //left
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }        
        prev = root;

        //right
        if(flag) helper(root.right);
        
    }
}