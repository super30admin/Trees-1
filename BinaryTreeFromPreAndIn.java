import java.util.*;
public class BinaryTreeFromPreAndIn{

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        TreeNode root = helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return root;
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int siPre,int eiPre,int siIn,int eiIn)
    {
        if(siPre>eiPre)
        {
            return null;
        }
        
        int rootData = preorder[siPre];
        
        TreeNode rootmain = new TreeNode(rootData);
        
        int rootIndex = -1;
        
        for(int i = siIn;i<=eiIn;i++)
        {
            if(inorder[i]==rootData)
            {
                rootIndex = i;
                break;
            }
        }
        
        int siPreLeft = siPre +1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex -1;
        int siInRight = rootIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;
        
        int leftSubTreeLength = eiInLeft - siInLeft + 1;
        int eiPreLeft = siPreLeft + leftSubTreeLength - 1;
        
        int siPreRight = eiPreLeft + 1;
        
        TreeNode left = helper(preorder,inorder,siPreLeft,eiPreLeft,siInLeft,eiInLeft);
        TreeNode right = helper(preorder,inorder,siPreRight,eiPreRight,siInRight,eiInRight);
        
        rootmain.left = left;
        rootmain.right = right;
        
        return rootmain;
    }
}