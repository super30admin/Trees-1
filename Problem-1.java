// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We perform inorder traversal of the given BST
// We maintain the last processed node as prev node. 
// Idea is that all the upcoming nodes should be always greater than or equal to prev node
// In every recursion call we check this and set the result bool flag accordingly
class Solution1 {
    TreeNode prev;
    boolean result;

    public boolean isValidBST(TreeNode root) {
        result = true;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            result = false;
            return;
        }
        prev = root;

        inorder(root.right);
    }
}