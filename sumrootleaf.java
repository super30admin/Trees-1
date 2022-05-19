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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        
        if(root==null) return 0;
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root,int rsum){
        
        if(root == null) return;
       
        
        helper(root.left,10*rsum+root.val);
        
        
         if(root.left==null && root.right==null){
            sum=sum+(10*rsum+root.val);
        }
        helper(root.right,10*rsum+root.val);
       
        
        return;
    }
}