// Problem1 - https://leetcode.com/problems/validate-binary-search-tree/

// Time Complexity : O(n)
// Space Complexity : O(h) // height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially struggled with optimized solution

class Solution {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        if (flag)
            inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            flag = false;
        }

        prev = root;

        if (flag)
            inorder(root.right);

    }
}