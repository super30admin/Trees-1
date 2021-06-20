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
// Time Complexity: O(n) ; Beacuse we are travesing each and every node in the worst case.
// Space Complexity: O(n) ; Space for stack

// 98. Validate Binary Search Tree

// The main idea in both recursive and iterative solutions is that, if, on BST an inorder traversal is done, then it results in ascending order of their node values. Hence to validate BST, we just check if this ascending order is maintained during inorder traversal (this is done by check if prev< curr node)


// 1. Iterative solution
class Solution {
    
   
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> st=new Stack<>(); 
        TreeNode prev=null;
        while(root!=null || !st.isEmpty())
        {
            
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            root=st.pop();
           // System.out.println(root.val);
           if(prev!=null && prev.val >= root.val)
               return false;
            
            prev=root;
            root=root.right;
            
            
        }
        return true;
        
     
    }
    
  /* 2. Recursive Solution
  
  class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        
      return  inorder(root);
    }
    
    public boolean inorder(TreeNode root)
    {
        boolean lt=false, rt=true;
        if(root==null)
            return true ;
        lt=inorder(root.left);
        //System.out.println(root.val);
        if(prev!=null && prev.val>= root.val)
            return false;
        prev=root;
        rt=inorder(root.right);
        
        return lt && rt;
      
    }
}*/
   
}