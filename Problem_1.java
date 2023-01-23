// 98. Validate Binary Search Tree
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// Traverse the tree in the inorder traversal manner
// Each time we process the value for the latest node, it must be grater than the previous value we have already processed.

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

// Recursive
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;

        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        inorder(root.right);
    }
}