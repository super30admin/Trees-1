//https://leetcode.com/problems/validate-binary-search-tree/
//Time complexity : O(N)
//Space complexity : O(1)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, Long min, Long max) {
        if (root == null)
            return true;
        boolean valid = min < root.val && root.val < max;
        if (!valid)
            return false;

        return helper(root.left, min, new Long(root.val)) && helper(root.right, new Long(root.val), max);
    }
}
