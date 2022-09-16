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
//sc- o(h)
//tc-o(n)
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
      return  inorder(root);
        
    }
    private boolean inorder(TreeNode root)
    {
        if(root == null) return true;
        //System.out.println(root.val);   
        
       boolean left = inorder(root.left);
        
        
          if(prev!=null && prev.val>=root.val)
          { 
          return false;
          }
        prev = root;
    boolean right = true;
        if(left)
       right =  inorder(root.right);
        
      return left&&right;
    }
}


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
//sc- o(h)
//tc-o(n)
/*class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
      return  inorder(root);
        
    }
    private boolean inorder(TreeNode root)
    {
        if(root == null) return true;
        System.out.println(root.val);   
        
       if( inorder(root.left) == false) return false;
        
        
          if(prev!=null && prev.val>=root.val)
          { 
          return false;
          }
        prev = root;
   
       return inorder(root.right);
        
    }
}*/