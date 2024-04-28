// Time Complexity : O(N) - no. of nodes in the tree
// Space Complexity : O(H) - h is height of the tree
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
class ValidateBinarySearchTree {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    public void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);
        if(prev != null && prev.val >= root.val) {
            flag = false;
            return;
        }
        prev = root;
        System.out.println(root.val);
        if(flag) {
            helper(root.right);
        }

    }
}

/**
 * Approach 2 : Maintaining min and max for each node and calling recurssion
 */
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }

    public void helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return;

        if((min != null && min >= root.val) || (max != null && max <= root.val )) {
            flag= false;
        }

        helper(root.left, min, root.val);
        helper(root.right,root.val,max);
    }
}