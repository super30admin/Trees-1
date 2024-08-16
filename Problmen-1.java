// Time Complexity : O(n)
// Space Complexity : O(h) hieght of the tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: I used the same logic Jaspinder explained. 

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
    TreeNode prev;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return flag;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        
        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        if(flag) helper(root.right);
    }
}