class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0, inorder.length-1, 0);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int i, int j, int idx){
        if(idx >preorder.length-1 || i>j)
            return null;
        TreeNode root = new TreeNode(preorder[idx]);
        int index = 0;
        for(int k=i;k<=j;k++){
            if(inorder[k]==root.val)
                index = k;
        }
        root.left = build(preorder,inorder,i,index-1,idx+1);
        root.right = build(preorder, inorder, index+1, j,idx+(index-i+1));
        return root;
    }
}
