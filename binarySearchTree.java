//Time complexity: O(n)
//Space complexity: O(n)
//Executed on leetcode.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;        //left child range is between left bound of the root node and root node value itself.
    if (upper != null && val >= upper) return false;        //right child range is between root node value and right bound of root node.  Based on these 2 condition traversing through tree. If fails returns false.

    //if (! helper(node.right, val, upper)) return false;
    //if (! helper(node.left, lower, val)) return false;
    return helper(node.right, val, upper)&&helper(node.left, lower, val);
  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }
    
}