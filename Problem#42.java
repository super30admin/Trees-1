// Validate Binary Search Tree

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

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
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        if(flag)
            inorder(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        System.out.println("Node: " + root.val);
        if(flag)
            inorder(root.right);
    }
}