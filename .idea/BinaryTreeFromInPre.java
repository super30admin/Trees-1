class BinaryTreeFromInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int rooti = 0;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootval)
            {
                rooti = i;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0 , rooti);
        int[] inRight =  Arrays.copyOfRange(inorder,rooti+1 , inorder.length);
        int[] preLeft =  Arrays.copyOfRange(preorder,1 , rooti+1);
        int[] preRight =  Arrays.copyOfRange(preorder,rooti+1 ,preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}


// time complexity is O(N^2)
//Space complexity is O(n^2)