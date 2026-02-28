// Time Complexity : O(n)
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use a helper method to traverse left and right children of root recursively and make sure to check
if the previous visited node's value is not greater than root value at each stack call, if so, update the
flag as false.We need to update the previous visited node with the current root to check for next stack/
child calls. This concept/intention maps to inorder traversal where visited elements are to be in ascending
order.
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
class Solution {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        validateBST(root);
        return flag;
    }

    private void validateBST(TreeNode root) {
        if(root == null)
            return;
        validateBST(root.left);
        if(prev != null && prev.val >= root.val)
            flag = false;
        prev = root;
        validateBST(root.right);
    }
}