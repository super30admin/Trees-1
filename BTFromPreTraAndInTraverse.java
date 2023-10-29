import java.util.HashMap;

public class BTFromPreTraAndInTraverse
{
    HashMap<Integer, Integer> map = new HashMap();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        for(int i =0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return helper( 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode helper( int inStartIdx, int inEndIdx, int[] preorder, int[] inorder)
    {
        if(inStartIdx > inEndIdx)
            return null;

        int rootNodeVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootNodeVal);
        int indexOfRootInorder = map.get(rootNodeVal);
        preIndex++;

        root.left = helper(inStartIdx, indexOfRootInorder-1,  preorder, inorder);
        root.right = helper(indexOfRootInorder+1, inEndIdx, preorder, inorder);

        return root;
    }

}
