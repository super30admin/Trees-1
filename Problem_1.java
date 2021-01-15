// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
        return validate(root,null,null);
    }
    
    public boolean validate(TreeNode root,Integer leftMargin,Integer rightMargin){
        if(root==null){
            return true;
        }
        
        if(leftMargin!=null && root.val<=leftMargin){
            return false;
        }
        if(rightMargin !=null && root.val>=rightMargin){
            return false;
        }
        return validate(root.left,leftMargin,root.val) && validate(root.right,root.val,rightMargin);
        
    }
}