import java.util.Arrays;

public class BinaryTreeFromPostorderInorder {

    public static TreeNode buildTree(int [] inorder, int [] postorder)
    {
        return helper(inorder, postorder);

    }

    public static TreeNode helper(int [] inorder, int [] postorder)
    {
        if(inorder.length == 0 ) {
             return null;
        }
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode((rootVal));
        int rootIdx =0;
        for(int i =0;i<inorder.length;i++)
        {
            if(rootVal == inorder[i])
            {
                rootIdx =i;
                break;
            }
        }
        int [] inleft= Arrays.copyOfRange(inorder, 0,rootIdx);
        int [] inright= Arrays.copyOfRange(inorder, 1+rootIdx,inorder.length);
        int [] postleft= Arrays.copyOfRange(postorder, 0,inleft.length);
        int [] postright= Arrays.copyOfRange(postorder, inleft.length,postorder.length-1);

        root.left =helper(inleft,postleft);
        root.right = helper(inright,postright);

        return root;

    }

    public static void main(String[] args)
    {
        int [] postorder = {9,15,7,20,3};
        int [] inorder = {9,3,15,20,7};
        TreeNode result = buildTree(inorder,postorder);
        printTree(result);



    }
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");  // Print root
        printTree(root.left);              // Print left subtree
        printTree(root.right);             // Print right subtree
    }
}
