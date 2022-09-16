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
    public boolean isValidBST(TreeNode root) {
 
      return helper(root,null,null);
        
        
    }
    private boolean helper(TreeNode root,Integer min,Integer max)
    {
        //base case
        if(root == null) return true;
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val >= max) return false;
        
        System.out.println(root.val);
        
        //logic
        //boolean left = helper(root.left,min,root.val);
        //boolean right = true;
        //if(left)
       // {
         //right = helper(root.right,root.val,max);
        //}
        
     //   return left&&right;
        
       return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    
    }
  
}