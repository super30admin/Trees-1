
// Time Complexity : O(h) where h is the height of the tree
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Three line explanation of solution in plain english

// In this approach we are using recursion to reach till point where we dont return false and reach a null node. If at any stage we don't see the 
// conditions being fulfilled we return a false an no more go ahead. 


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
      
      return validate(root , null , null);
        
    }
  
  private boolean validate(TreeNode node , Integer low, Integer high)
  {
    if(node==null)
    {
      return true;
    }
    if((low != null && low >= node.val)||(high != null && high <= node.val ))
    {
      return false;
    }
    
    return validate(node.left , low , node.val) && validate(node.right , node.val , high);
  }
}