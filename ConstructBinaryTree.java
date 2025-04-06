class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        int rootVal = preorder[0];
        int rootIdx = -1;
        for(int i=0; i<inorder.length; i++){
            if(rootVal == inorder[i]){
                rootIdx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        //Because rootVal = preorder[0] we start from index 1
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, inorder.length);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}