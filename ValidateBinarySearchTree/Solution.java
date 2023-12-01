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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Recursively traverse through the entire tree in inorder manner. Make a note of the previous node. Check if the value of current
 * node is less than previous node at each stage. If not, return false.
 */
class Solution {

    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        validate(root);
        return flag;
    }

    private void validate(TreeNode root) {

        if(root == null || !flag) return;

        validate(root.left);

        if(prev != null && prev.val >= root.val) {
            flag = false;
            return;
        }

        prev = root;

        validate(root.right);
    }
}

/**
 * converting GLOBAL VARIABLE to local parameter in recursion stack using PASS BY REFERENCE
 */
/*
class Solution {

    public boolean isValidBST(TreeNode root) {

        return validate(root, new TreeNode[1]);
    }

    private boolean validate(TreeNode root, TreeNode[] prev) {

        if(root == null ) return true;

        if(!validate(root.left, prev)) return false;

        if(prev[0] != null && prev[0].val >= root.val)
            return false;
        prev[0] = root;

        return validate(root.right, prev);
    }
}*/


/**
 * BOOLEAN BASED RECURSION
 */
/*
class Solution {

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return validate(root);
    }

    private boolean validate(TreeNode root) {

        if(root == null ) return true;

        if(!validate(root.left)) return false;

        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;

        return validate(root.right);
    }
}*/
