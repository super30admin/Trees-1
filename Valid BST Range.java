// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        // base
        if(root == null) return true;
        
        // check for min and maximum bound
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;
        
        boolean left = helper(root.left, min, root.val);
        
        // check if left is empty
        if(!left) return false;
        
        boolean right = helper(root.right, root.val, max);
        
        return left && right;
    }
}