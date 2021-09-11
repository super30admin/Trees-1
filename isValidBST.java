// Time Complexity : O(n) where n is the total number of nodes
// Space Complexity : O(1)
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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        //base
        if(root == null){
            return true;
        }
        //logic
        boolean left = isValidBST(root.left);
        if(prev != null && root.val <= prev.val){
            return false;
        }
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
