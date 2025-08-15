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

 // Idea is to pass min and max values for each node and check if any node violates the binary search tree condition.

 // Time Complexity: O(n)
 // Space Complexity: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return traversal(null,null,root);
    }

    public boolean traversal(Integer min, Integer max, TreeNode root)
    {
        if(root==null) return true;
        if(max!=null && root.val>=max) // Check if max condition is violated.
        {
           return false;
        }
        if(min!=null && root.val<=min)// Check if min condition is violated.
        {
           return false;
        }
        return traversal(min,root.val,root.left)&&traversal(root.val,max,root.right);
    }
}