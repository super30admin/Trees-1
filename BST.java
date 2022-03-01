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
        //the value at every node must be within certain bounds
        //initially(min,max)
        return isValidRecursive(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean isValidRecursive(TreeNode root, long min, long max) {
        if (root == null) return true;
        //check if value is within min and max limits
        if(root.val <min || root.val > max) return false;
        //for left node, the limit is (min, parent.val) and for right (parent.val, max)
        return isValid(root.left, min, root.val) && isValid(root.right,root.val, max);
    }
}