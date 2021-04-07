// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    TreeNode prev;
    Boolean isBST;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        isBST = true;
        inorder(root);
        return isBST;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        // got to the left most subtree
        inorder(root.left);
        // check if the value we seen is > the current value
        if (prev != null && prev.val >= root.val)
            isBST = false;
        // assign the value we seen
        prev = root;
        inorder(root.right);
    }
}