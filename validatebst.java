// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we are storing the previous element using a pointer and comparing it with the root element's value
// we are following inorder so root element is in the middle . it should be greater than the previous value 

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
        this.flag= true;
        helper(root);
        return this.flag;
    }
    private void helper(TreeNode root)
    {
        //base
        if(root==null) return;
        if(flag)
            helper(root.left);
        //logic
        if((prev!=null) && (prev.val >= root.val))
        {
            // System.out.println(prev.val);
            // System.out.println(root.val);
            flag= false;
        }
        prev= root;
       if(flag)
            helper(root.right);
        
    }
}