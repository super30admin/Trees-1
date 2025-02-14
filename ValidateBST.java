// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
 We do inorder traversal here. We use previous pointer initially pointing to null.
 While traversing we check if previous value>=current value, then return false.
 */
public class ValidateBST {
    TreeNode prev=null;
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return flag;
    }

    private void helper(TreeNode root){
        if(root==null || !flag){
            return ;
        }
        helper(root.left);
        if(prev!=null && prev.val>=root.val){
            flag=false;
        }
        prev=root;
        helper(root.right);
    }
}