// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using in order traversal to keep track of the range of values for left and right subtrees.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;

        if (min != null && node.val <= min)
            return false;

        if(max != null && node.val >= max)
            return false;

        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}