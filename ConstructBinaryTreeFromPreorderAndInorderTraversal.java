import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
In preorder array we more left to right, because we get the first element as the root element. We store elements and their indexes of inorder array in 
map. Using root as preorder element, we find its index in inorder array using the map. left of this index would be the left subtree and right of this index would be the 
right subtree.
*/
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
   int idx;
   public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<inorder.length;i++){
           map.put(inorder[i],i);
       }
       return helper(preorder,map,0,inorder.length-1);
   }

   TreeNode helper(int[] preorder, Map<Integer,Integer> map,int start, int end){
       //base
       if(start>end){
           return null;
       }

       //logic
       int rootval=preorder[idx];
       idx++;
       TreeNode root=new TreeNode(rootval);
       int rootidx=map.get(rootval);
       root.left = helper(preorder,map,start,rootidx-1);
       root.right = helper(preorder,map,rootidx+1,end);
       return root;

   }
}