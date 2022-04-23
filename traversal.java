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
    public boolean isValidBST(TreeNode root) {

        inorder(root);
        postorder(root);
        preorder(root);
        return true;
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    private void postorder(TreeNode root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
    private void preorder(TreeNode root){
        if(root == null) return;

        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

}