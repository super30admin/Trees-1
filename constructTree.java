// Time complexity : o(n*n)
// space complexity: o(n*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int index=-1;
        int rootValue = preorder[0];
        TreeNode root= new TreeNode(rootValue);
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootValue)
            {
                index=i;
                break;
            }

        }
        int[] preOrderleft=Arrays.copyOfRange(preorder,1,index+1);
        int[] preOrderright=Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] inleft=Arrays.copyOfRange(inorder,0,index);
        int[] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left=buildTree(preOrderleft,inleft);
        root.right=buildTree(preOrderright,inright);
        return root;

    }
}
