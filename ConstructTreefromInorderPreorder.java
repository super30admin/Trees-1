
// Time Complexity : O(h) where h is the height of the tree
// Space Complexity :O(ne
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      
      if(preorder == null || preorder.length==0)
      {
        return null;
      }
      
      TreeNode root = new TreeNode(preorder[0]);
      int index = -1;
      for(int i = 0 ; i<inorder.length;i++)
      {
        if(inorder[i]==root.val)
        {
          index = i;
          break;
        }
      }
      
      int[] preLeft = Arrays.copyOfRange(preorder,1,index+1);
      int[] preRight = Arrays.copyOfRange(preorder,index+1,preorder.length);
      
      int[] inLeft = Arrays.copyOfRange(inorder,0,index);
      int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);

      root.left = buildTree(preLeft,inLeft);
      root.right = buildTree(preRight,inRight);
      
      return root;
        
    }
}