// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we are going in inorder and just maintaning the previous node

inorder on a BST will give us elements in assending order
*/

class Solution {
    private boolean flag;
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        if (prev != null && root.val <= prev.val) {
            flag = false;
        }
        prev = root;
        helper(root.right);
    }
}