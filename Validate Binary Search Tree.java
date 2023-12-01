// Time Complexity :O(n), n is number of nodes
// Space Complexity :O(h),h is height of tree
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
    //boolean flag;
      TreeNode prev;
    public boolean isValidBST(TreeNode root) {
      //  this.flag=true;
       return helper(root);
      //  return flag;
    }

    public boolean helper(TreeNode root)
    {
        if(root==null)
        return true;

        boolean left=helper(root.left);
        if(prev!=null && prev.val>=root.val)
        return false;

        prev= root;

         
         boolean right= helper(root.right);

         return left && right;

    }
}