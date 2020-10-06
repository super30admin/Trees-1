// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using recurression method

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
        return NodeBST(root, null, null);
    }
    private boolean NodeBST(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        int val = root.val;
        if(min != null && val <= min) return false;
        if(max != null && val >= max) return false;
        return NodeBST(root.left, min, val) && NodeBST(root.right, val, max);
    }
}
