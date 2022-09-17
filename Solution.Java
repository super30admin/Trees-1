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
        TreeNode root = new TreeNode();
        if(preorder.length ==0)
            return null;

            int rootval = preorder[0];
            
            root.val = rootval;
            int inorderposition =-1;
            for(int i=0;i<inorder.length;i++)
            {
                if(inorder[i] == rootval)
                {
                    inorderposition = i;
                    
                    break;
                }
            }
            int [] inorderleft = Arrays.copyOfRange(inorder,0,inorderposition);
            int[] inorderright = Arrays.copyOfRange(inorder,inorderposition+1,inorder.length);
            int[] preorderleft = Arrays.copyOfRange(preorder,1,inorderleft.length+1);
            int[] preorderright = Arrays.copyOfRange(preorder,preorderleft.length+1,preorder.length);   
             root.left = buildTree(preorderleft,inorderleft);
             root.right = buildTree(preorderright,inorderright);
            
        return root;
    }
    
}
