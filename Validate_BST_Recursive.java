// 98. Validate Binary Search Tree - https://leetcode.com/problems/validate-binary-search-tree/
// Time Complexity - O(N), no. of nodes
// Space Complexity - O(H), height of tree
// Run on leetcode? - yes

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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        result=true;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root==null) return;
        
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            result = false;
            return;
        }
        prev=root;
        inorder(root.right);
    }
}