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
//T(N)=O(N)
//S(N)=O(N^2)
class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null; //null
        
        int rootVal=preorder[0];
        int indx= -1;
        TreeNode root=new TreeNode(rootVal);
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)
                indx=i;     //Finding and Updating root in inorder
        }
        int[] inleft=Arrays.copyOfRange(inorder,0,indx);
        int[] inright=Arrays.copyOfRange(inorder,indx+1,inorder.length);
        int[] prleft=Arrays.copyOfRange(preorder,1,1+inleft.length);
        int[] prright=Arrays.copyOfRange(preorder,1+inleft.length,preorder.length);
        
        root.left=buildTree(prleft,inleft);
        root.right=buildTree(prright,inright);
        
        return root;
        
        
    }
}