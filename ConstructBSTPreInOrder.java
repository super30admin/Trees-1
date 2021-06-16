class ConstructBSTPreInOrder {
    //Not fully sure how to implement will update after class
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = new TreeNode(preorder[0]);

        for (int i=1; i<preorder.length; i++) {

            root.left = preorder[i * 2 + 1];
            root.right = preorder[i * 2];

        }
    }
}