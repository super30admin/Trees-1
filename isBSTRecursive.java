//Recursive algorithm for check if the given tree is BST or not
//In this approach, I have initialized two global variable(its not a good practice)
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
    
    //creating gloabal variable result, prev
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        
        result = true;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //left
        inorder(root.left);
        //root
        if(prev!=null && prev.val >= root.val){
            result = false;
            //can just return, because once its false, no need to iterate other nodes in the tree.
            return;
        }
        prev = root;
        //right
        inorder(root.right);
    }
}