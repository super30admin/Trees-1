//Space Complexity = O(n)
//Time Complexity = O(n)
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
    Boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.result = true;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && root.val <= prev.val){
            result = false;
        }
        prev = root;
        if(result){
            helper(root.right);
        }
        
    }
}