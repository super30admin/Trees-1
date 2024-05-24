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

 /**
 
 Keep build Inorder and preOrder of sub trees.

 TC: O(N^2), SC: O(N);
  */
  class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; int m = inorder.length;
         
         if(n == 0 || m == 0) return null;
         int rootVal = preorder[0];
         int rootInd = -1;

         // Identify root 
         for(int i =0;i<m;i++){ // O(N)
            if(rootVal == inorder[i]){
                rootInd = i;
            }
         }
        TreeNode root = new TreeNode(rootVal);
         // copy inLeft, inRight, Preleft, preRight values from inorder array

         //O(2N)
         int[] inLeft = Arrays.copyOfRange(inorder,0,rootInd);
          int[] inRight = Arrays.copyOfRange(inorder,rootInd+1,m);

          int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
          int[] preRight = Arrays.copyOfRange(preorder,inLeft.length+1, n);


          root.left = buildTree(preLeft, inLeft);
          root.right = buildTree(preRight, inRight);

          return root;

    }
}