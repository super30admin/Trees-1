// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree. Best case: O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
      return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
  
    boolean helper(TreeNode node, long max, long min) {
      if(node == null) return true;
      // If value of node is less than min or greater than max then it's not a valid BST.
      if(node.val<=min || node.val>=max) return false;
      // Left node, max value can be root node's vale. Right node, min value can be root node's value.
      return helper(node.left, node.val, min) && helper(node.right, max, node.val);
    }
  }