// Time Complexity : O(n) – visit each node once
// Space Complexity : O(h) – recursion stack height (worst-case O(n) for skewed tree)
// Did this code successfully run on Leetcode : Yes
// Approach:
// 1) Carry valid range [min, max) down the tree; start with (Long.MIN_VALUE, Long.MAX_VALUE).
// 2) At each node, require min < node.val < max; otherwise return false.
// 3) Recurse left with (min, node.val) and right with (node.val, max); combine with AND.

public class ValidateBST {
    public boolean isValidBST(TreeNode root){
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max){
            return false;
        }

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
