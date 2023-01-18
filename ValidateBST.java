//tc : O(n)
//sc : O(log(n)) or height of the tree
//run successfull
//no problems


//solved the problem by follwing the inorder traversal
//checking the conditions for the 


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
    boolean isBST;
    public boolean isValidBST(TreeNode root) {
        isBST = true;
        inorder(root);
        return isBST;
    }

    private void inorder(TreeNode root){
        //base case 
        if(root == null) return ;
        //logic
        inorder(root.left);
        if(prev!=null && prev.val >= root.val) isBST=false;
        prev = root;
        //System.out.print(root.val + " ");
        if(isBST) inorder(root.right);
    }
}