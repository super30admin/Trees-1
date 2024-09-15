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
    public boolean isValidBST(TreeNode root) {
         return inorder(root);   
    }
    
    private boolean inorder(TreeNode root){
        if(root == null ) return true; // kept traversing upto null but dint hit an invalid         BST case hence returning true   
      //is stack is not empty or root is not  null then keep exploring till root is null 
      // inorder(root.left); continue going left till root is null
      //even if inorder returns true it is ok we still have to check the right subtree but 
      //if false then dont explore right subtree return
        if( inorder(root.left) == false ) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
       return  inorder(root.right);  //right subtree can give true or false
    }
    
}

/*
Time and Space Complexity : O(H) H is height of tree
*/