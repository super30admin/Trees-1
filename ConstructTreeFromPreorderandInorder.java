import java.util.HashMap;

// Time Complexity : O(N)
// Space Complexity : o(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach
1) have an index as a global value to iterate over the preorder array
2) we declare a hashmap to store the value and index from inorder array
3) that will help in determining the index at which we can break the tree and Construct from the preorder array
*/


/**
 * Definition for a binary tree node.
 */ 
 
class Solution {
    
    HashMap<Integer,Integer> map;
   int index;
   public TreeNode buildTree(int[] preorder, int[] inorder) {

     if(preorder==null || preorder.length==0)
     {
         return null;
     }
       
      map = new HashMap<>();
       for(int i=0;i<inorder.length;i++)
       {
           map.put(inorder[i],i);
       }
       
       return helper(preorder,inorder,0,preorder.length-1);
   }
   
   public TreeNode helper(int[] preorder,int[] inorder,int start,int end)
   {
       // base
       if(start>end)
       {
           return null;
       }
       
       // logic
       int rootVal = preorder[index];
       index++;
       TreeNode node = new TreeNode(rootVal);
       int rootIdx = map.get(rootVal);
       node.left=helper(preorder,inorder,start,rootIdx-1);
       node.right=helper(preorder,inorder,rootIdx+1,end);
       
       return node;
   }


   public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}