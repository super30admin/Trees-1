public class ConstructBinaryTreefromPreorderandInorderTraversal {
    //TC: O(n)
    //SC: O(n)
 public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length == 0) return null;

        //logic
        //root in preorder
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int idx = -1; //root index in inorder traversal
        //root in inorder
        for(int i =0; i<inorder.length; i++){
            if(inorder[i]==rootval){
                idx=i;
            }
        }
        int inLeft[] = Arrays.copyOfRange(inorder,0,idx);
        int inRight[] = Arrays.copyOfRange(inorder,idx+1,inorder.length);

        int preLeft[] = Arrays.copyOfRange(preorder, 1, 1+inLeft.length);
        int preRight[] = Arrays.copyOfRange(preorder, 1+inLeft.length, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
