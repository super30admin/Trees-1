// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem 1
// https://leetcode.com/problems/validate-binary-search-tree/

// Given a binary tree, determine if it is a valid binary search tree (BST). Assume a BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:

//    2
//    / \
//   1   3

// Input: [2,1,3]
// Output: true
// Example 2:

//    5
//    / \
//   1   4
//      / \
//     3   6

// Input: [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

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

    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        // Base: if root is null, returning true
        if (root == null){
            return true;
        }

        isValid = true;
        checkValidity(root, null, null);
        return isValid;
    }

    private void checkValidity(TreeNode root, Integer min, Integer max){
        // Base condition
        if (root == null){
            return;
        }

        // Logic
        // The current node must be strictly within min < val < max
        if ((min != null && root.val <= min) || (max != null && root.val >= max)){
            isValid = false;
            return;
        }
        
        // Checking left subtree with updated max
        checkValidity(root.left, min, root.val);

        // Checking right subtree with updated min
        checkValidity(root.right, root.val, max);
    }
}
