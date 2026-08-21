
//Time Complexity : O(n2)
//Space Complexity: O(1)
class BinaryTreePreOrderInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        //PreOrder - root, left, right
        //InOrder  - left, root, right
        if(preorder.length == 0) return null;
        int idx = -1;
        int rootVal = preorder[0]; // first element in preOrder is nothing but root
        TreeNode root = new TreeNode(rootVal);

        //Finding the index of the root value in the inorder array
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                idx = i;
                break;
            }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, idx+1);
        int[] preRight = Arrays.copyOfRange(preorder, idx+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);

        root.left  = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}