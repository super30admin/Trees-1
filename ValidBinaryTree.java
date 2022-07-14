import java.util.Stack;

import javax.swing.tree.TreeNode;

//Time Complexity- O(n)
//Space Complexity- O(h) where h is the depth of the tree
//Successfully ran on leetcode
class Solution {
    
 public boolean isValidBST(TreeNode root){
         TreeNode prev=null;
     
     if(root == null) return true;
    
     Stack<TreeNode> s= new Stack<>();
    
 while(root!= null || !s.isEmpty()){
     while(root!= null){
         s.push(root);
         root=root.left;
     }
     
     root = s.pop();
     if(prev != null && prev.val >= root.val) return false;
     prev = root;
     root= root.right;
 }
     
     return true;
     
}
 
}
         
      


 
