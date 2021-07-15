
public class PreOrderandInorderTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        //find root in preorder
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        //search root in inorder
        int rootIdx = 0;
        for(int i = 0 ; i< inorder.length; i++){
            if(inorder[i]== rootVal)
                rootIdx = i;                
        }
        int[] preleft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preright = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);
        int[] inleft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inright = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        return root;
        
    }


}
