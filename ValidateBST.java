/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: O(n) 
// space: O(n)
// passed all testcases
class Solution {
    public boolean isValidBST(TreeNode root) {
       if(root==null) return true;
         return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    // for every iteration we will record min and max. for left child we have to check value should be less     than  max and for right child value should be greater min
    public boolean isValid(TreeNode root, long min,long max)
    {
       if(root==null) return true;
       if(root.val<=min || root.val>=max) return false;
       return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
        
    }
}