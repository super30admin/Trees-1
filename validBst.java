// Time Complexity : O(n) - total nodes in terr
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    boolean result;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        result = true;
        inorder(root);
        return result;
        
    }
    private void inorder(TreeNode root){
        
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            result = false;
        }
        prev = root;
        inorder(root.right);
    }
}