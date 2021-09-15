// Time Complexity : O(n), We traverse oncethrough the tree.
// Space Complexity : O(1), No extra space is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        result = true;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            result = false;
        }
        prev =root;
        inorder(root.right);
    }
}

/* Have done inorder travesal using recursive approach instead of initializing stack and iterating*/