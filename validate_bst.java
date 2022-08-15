//TC:O(n)
//SC:O(h) max elements in the stack are always lessthan or equal to number of height nodes
//leecode : successfull
//approach
//
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
     boolean flag;
    public boolean isValidBST(TreeNode root) {
       flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
        if(flag){
            inorder(root.left);
        }
        if(prev!=null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        if(flag){
            inorder(root.right);
        }
        
    }
}