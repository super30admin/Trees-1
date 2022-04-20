/**
Problem: https://leetcode.com/problems/validate-binary-search-tree/
TC: O(2^n) where n is the max height of the tree
SC: O(n) for recursion stack where n = max height of tree
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        
        return (
            (min < root.val && root.val < max) &&
            isValidBST(root.left, min, root.val) &&
            isValidBST(root.right, root.val, max)
        );
    }
}