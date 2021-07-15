//Basic Recursive algorithm of preorder traversal

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
    
    //creating gloabal variable result
    boolean result;
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        inorder(root);
        return true;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //left
        inorder(root.left);
        //root
        System.out.println(root.val);
        //right
        inorder(root.right);
    }
}
