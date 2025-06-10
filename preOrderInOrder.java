//preorder[0] is the root and find its index in the inorder array to split it into left and right subtrees. 
//Time complexity: O(n^2)
//Space complexity: O(n^2)

import java.util.Arrays;

import javax.swing.tree.TreeNode;

class Solution {

   public TreeNode buildTree(int[] preorder, int[] inorder) {

       if(preorder.length==0) return null;

       TreeNode root= new TreeNode(preorder[0]);

       int index=-1;

       for(int i=0;i<inorder.length;i++)

       {

           if(inorder[i]==root.val)

           {

               index=i;

               break;

           }    

       }

       int[] preleft=Arrays.copyOfRange(preorder,1,index+1);

       int[] preright=Arrays.copyOfRange(preorder,index+1,preorder.length);

       int[] inleft= Arrays.copyOfRange(inorder,0,index);

       int [] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);

       root.left=buildTree(preleft,inleft);

       root.right=buildTree(preright,inright);

       return root;

   }

}