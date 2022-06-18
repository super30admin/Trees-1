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
 */class Solution {
   
   //tc:O(n) sc: O(height)
   
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }
    public boolean checkBST(TreeNode root, TreeNode left, TreeNode right){
        if(root == null){
            return true;
        }
        if((left != null && root.val <= left.val) || (right!= null && root.val >= right.val)){
            return false;
        }
        return checkBST(root.left, left, root) && checkBST(root.right, root, right);
    }
}
