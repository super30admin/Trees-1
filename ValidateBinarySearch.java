// Time Complexity : O(N), N is the max number of elements in the tree
// Space Complexity : O(H) where H is the height of the tree. This will be the max amount of space used in the stack.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        // base case
        if (root == null) return isValid;

        isValid = true;
        inOrderTraversal(root);

        return isValid;
    }

    private void inOrderTraversal(TreeNode root) {
        // base case
        if (root == null) return;

        // Left sub-tree
        if (isValid) inOrderTraversal(root.left);
        if (prev !=null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        // Right sub-tree
        if (isValid) inOrderTraversal(root.right);
    }
}