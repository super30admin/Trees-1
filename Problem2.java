//Method1: Bruteforce Approach
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
//TC:O(N*N)
//Sc:O(N*N)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         if(preorder==null||preorder.length==0)return null;
         TreeNode root=new TreeNode(preorder[0]);
         int pre_indx=0;
         for(int i=0;i<inorder.length;i++){
             if(inorder[i]==preorder[0]) {
                 pre_indx=i;
                 break;
             }
         }
         int[] pre_left=Arrays.copyOfRange(preorder,1,pre_indx+1);
         int[] pre_right=Arrays.copyOfRange(preorder,pre_indx+1,preorder.length);
         int [] in_left=Arrays.copyOfRange(inorder,0,pre_indx);
         int[]  in_right=Arrays.copyOfRange(inorder,pre_indx+1,inorder.length);
         root.left=buildTree(pre_left,in_left);
         root.right=buildTree(pre_right,in_right);

         return root;
    }
}