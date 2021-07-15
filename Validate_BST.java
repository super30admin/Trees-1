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
    public boolean isValidBST(TreeNode root){
        if(root==null)
            return true;
        result = true;
        helper(root, null, null);
        return result;
    }
    
    private void helper(TreeNode root, Integer min, Integer max){
        // base
        if(root == null) return;
        // min, root.val
        helper(root.left,min,root.val);
        if( (max != null && root.val>= max) || (min!=null && root.val <= min)){
            result=false;
            return;
        }
        helper(root.right, root.val, max);
    }
}