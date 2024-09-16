// Time Complexity :o(n^2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
//Not sure if time and space complexities are correct

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        
      int index=preorder[0];
     int rootindex=0;
      for(int i=0;i<inorder.length;i++){
          if(index == inorder[i]){
            rootindex=i;
              break;
          }   
      }
        TreeNode root= new TreeNode(index);    
        
        int[] leftinorder=Arrays.copyOfRange(inorder, 0, rootindex);
       int[] rightinorder=Arrays.copyOfRange(inorder, rootindex+1,inorder.length);
        
        
            //Leftsortedarray
       int[] leftarray= Arrays.copyOfRange(preorder, 1,rootindex+1);
        //rightsortedarray
         int[] rightarray= Arrays.copyOfRange(preorder,rootindex+1,preorder.length);
        
          root.left= buildTree(leftarray,leftinorder)  ;
            root.right= buildTree(rightarray,rightinorder);
          return root;             
    }

}