// Time Complexity : O(n)
// Space Complexity : O(h) h - height of the tree

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
        return helper(root,null,null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base case
        if(root == null)
            return true;
        if(max != null && root.val >= max)
            return false;
        if(min != null && root.val <= min)
            return false;
        //logic - change max and min based on left node or right node
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}