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
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        System.out.println(root.val);
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root==null || flag == false) return;
        inorder(root.left);
        if(prev !=null && prev.val >=root.val){
        flag = false;
    }
    prev=root;
     inorder(root.right);
    }
}