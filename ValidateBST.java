// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

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
    boolean flag = true;
    // Use previous to store the previous node value traversed in Inorder
    int previous;
    int count=0;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(count!=0 & root.val<=previous){
            flag = false;
            return;
        }
        else{
            previous = root.val;
            count++;
        }
        inorder(root.right);
    }
}