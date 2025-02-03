// Time Complexity : O(N)
// Space Complexity : O(H)
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
 
 // The or part also works
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Long min, Long max) {
        // base
        if(root == null) return true;
        // if(min != Long.MIN_VALUE && root.val <= min) return false;
        // // if(min != null && root.val <= min) return false;
        // // if(max != null && root.val >= max) return false;
        // if(max != Long.MAX_VALUE && root.val >= max) return false;
        // // logic
        // boolean left = true, right = true;
        // left = helper(root.left, min, (long)root.val);
        // if(left) right = helper(root.right, (long)root.val, max);
        // return left && right;
        if((min != Long.MIN_VALUE && root.val <= min) || (max != Long.MAX_VALUE && root.val >= max))
            return false;
        return helper(root.left, min, (long)root.val) && helper(root.right, (long)root.val, max);
    }
}