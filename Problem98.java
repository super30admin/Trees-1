// Time Complexity : O(n) -- no.of nodes in BST
// Space Complexity :  O(h) -- stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


 // void based
class Solution {
     boolean flag;
     TreeNode prev;
     public boolean isValidBST(TreeNode root) {
        flag = true;
        return helper(root);
         return flag;
     }
 
      public void helper(TreeNode root){
 
          //base
          if(root== null) return ;
 
           helper(root.left);
 
         if(prev!=null && prev.val >= root.val){
              flag = false;
             return;
          }
           prev= root;
         
           helper(root.right);
         
      }
    }
 // boolean based recurssion
    class Solution {
        
         TreeNode prev;
         public boolean isValidBST(TreeNode root) {
           return helper(root);
         }
 
     public boolean helper(TreeNode root)
     {
         if(root == null) return true;
 
        boolean left = helper(root.left) ;
       if(!left) return false;
       if(prev!=null && prev.val >= root.val)
        return false;
 
        prev= root;
        
       return helper(root.right);
        
     }
 
 
 }