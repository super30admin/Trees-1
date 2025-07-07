// Time Complexity : O(n)
// Space Complexity : O(n) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - I maintianed 2 bound variables - left and right. For any subtree going left, the value cannot be more than right - even when it goes left and then right in subtree. Same for right - the value cannot be less than left - even when it goes right and then left in subtree.
// I initially set the bounds to Long.MAX_VALUE and Long.MIN_VALUE to avoid edge cases where the node value is Integer.MAX_VALUE or Integer.MIN_VALUE.
// Basically, I am checking for every node if it is within the bounds and updating the bounds as I go down the tree - as the binary search tree property is maintained for every subtree.

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, long maxRight, long minLeft){
        if(root==null) return true;
        if(root.val >= maxRight || root.val <= minLeft) return false;
        boolean left = helper(root.left, root.val, minLeft);
        boolean right = helper(root.right, maxRight, root.val);
        return left && right;
    }
}