import java.util.Arrays;

public class BinaryTreeFromPreorderInorder {

    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return helper(preorder,inorder);

    }
    private static TreeNode helper(int[] preorder, int[] inorder) {
        //base case
        if(preorder.length == 0 || inorder.length ==0) return null;


        //logic
        int rootIdx = 0;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, rootIdx );
        int[] inright = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] preleft = Arrays.copyOfRange(preorder, 1, 1+inleft.length);
        int[] preright = Arrays.copyOfRange(preorder, 1+inleft.length,preorder.length);

        root.left = helper(preleft,inleft);
        root.right = helper(preright,inright);
        return root;




    }
    public static void main(String[] args)
    {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode result = buildTree(preorder,inorder);
        printTree(result);



    }
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");  // Print root
        printTree(root.left);              // Print left subtree
        printTree(root.right);             // Print right subtree
    }

}
