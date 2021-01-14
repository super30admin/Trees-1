//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//Time complexity : O(N^2)
//Space complexity : O(1)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);   
    }
    
    public TreeNode helper(int preorder[],int[] inorder,int preLow,int preHigh,int inLow,int inHigh){
        if(preLow > preHigh || inLow > inHigh)
            return null;
       
        TreeNode root = new TreeNode(preorder[preLow]);
        int index = 0;
        while(index < inorder.length && inorder[index] != root.val){
            index++;
        }
        int leftLen = index - inLow;
        root.left = helper(preorder,inorder,preLow+1,preLow + leftLen,inLow,index-1);
        root.right = helper(preorder,inorder,preLow+leftLen+1,preHigh,index+1,inHigh);
        return root;
    }
}