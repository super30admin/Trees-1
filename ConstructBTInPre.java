import java.util.*;

//TC: O(N^2) N - number of nodes 
//SC: O(N) N- number of nodes

//preorder traversal has root as the first element. We will find the index of that element in inorder array.
//The root in inorder array, divides array into left and right subtree.
//We repeat the process of finding subsequent roots of left n right trees from preorder array.

public class ConstructBTInPre {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                index = i;
                break;
            }
        }
       
        int[] pLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] pRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        int[] iLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] iRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(pLeft, iLeft);
        root.right = buildTree(pRight, iRight);
        
        return root;
    }

    public static void printInorder(TreeNode root){

            if(root == null) return;
            printInorder(root.left);
            System.out.println(root.val);
            printInorder(root.right);
        }


    public static void main(String[] args){
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode root = buildTree(pre,in);
        printInorder(root);

    }


}
