// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes

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
        return valid(root, null, null);
    }
    public boolean valid(TreeNode root, Integer min, Integer max){
        if(root == null) return true; 
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return (valid(root.left, min, root.val) &&
        valid(root.right, root.val, max));
    }
}