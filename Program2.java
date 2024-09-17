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
        
        if(preorder.length==0){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int index=-1;
        for(int i=0; i<inorder.length;i++){
            if(root.val==inorder[i]){
                index=i;
            }
        }
        
        int[] pre_left=Arrays.copyOfRange(preorder,1,index+1);
        int[] in_left=Arrays.copyOfRange(inorder,0,index);
        
        int[] pre_right= Arrays.copyOfRange(preorder,index+1, preorder.length);
        int[] in_right=Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left=buildTree(pre_left,in_left);
        root.right= buildTree(pre_right,in_right);
        
        return root;
        
        
    }
}