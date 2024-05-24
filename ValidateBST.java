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

/*
If a tree has sorted values during in order traversal then the tree is a valid BST.
 

 Brute force: store inorder in list and check if list is sorted: 
 TC - O(2n), SC - O(n)+O(height)

 Optimal: Keep a previous node and check with root value. Then make prev as root and go to next value in tree.

 TC - O(N), SC = O(H)


 We store a min and max for each node and maintain it to check if each value lies in its ranges.
 TC  : O(N), SC : O(N)
*/
  
class Solution {

    // Approach: Inorder traversal with prev pointer
    TreeNode prev ;
    boolean flag;
    public boolean isValidBST1(TreeNode root) {
        this.flag = true;
        
        inorder(root);
        return flag;
    }

    private void inorder( TreeNode root){

        if(root == null || !flag) return;
        
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            flag = false;
        }
        prev = root;
        inorder(root.right);

    }
    // Approach:  min and max values check boundary
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);
    }
    private boolean validate(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if((min!=null &&root.val<=min) || (max!=null && root.val>=max)) return false;
        return validate(root.left, min,root.val) && validate(root.right,root.val,max);
    }
}