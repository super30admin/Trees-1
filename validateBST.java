// Time Complexity: O(n) where n is the number of nodes
// Space Complexity: O(Edge) occupied by recursive stack

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
    boolean result;
    public boolean isValidBST(TreeNode root) {
        result = true;
        helper(root);
        return result;
    } 
    
    public void helper(TreeNode root){     
        if(root == null) return;
        
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            result = false;
            return;
        }
        prev = root;
        helper(root.right);
    }
}