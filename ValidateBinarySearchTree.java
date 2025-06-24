// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree (due to recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Use a top-down recursive strategy to validate whether the tree satisfies BST properties.
// Each node must lie in a valid range defined by `min` and `max`.
// For the left child, the max allowed value becomes the current node's value.
// For the right child, the min allowed value becomes the current node's value.
// If any node violates the min/max constraint, return false. If all nodes are valid, return true.
// This method ensures strict ordering without needing to store or track the previous node.

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
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){

        if(root == null) return true;

        if(min != null && root.val <= min) {
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }

        //System.out.println(root.val);
        return helper(root.left,min, root.val) && helper(root.right, root.val, max);

    }
}