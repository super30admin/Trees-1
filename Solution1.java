// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
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
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        isValid = true;
        inorder1(root);
        return isValid;
    }
    private void inorder1(TreeNode root){
        if(root == null){
            return;
        }
        inorder1(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
        }
        prev = root;
        inorder1(root.right);
        //System.out.println("S : " + root.val);
    }
}