import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
 * Pre order: root-left-right
 * In order : left-root-right
 * 
 * For a element at i (limit 0->n-1) the left subtree in inorder array is start,
 * j-1 & right subtree is j+1, n-1; where j is the index where
 * preOrder[i]==inOrder[j]
 * 
 * 
 * 
 */

 
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(inorder.length==0) return null;

        int rootVal = preorder[0];
        int indx = 0;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==rootVal){
                indx=i;
            }
        }

        int[] inLeft= Arrays.copyOfRange(inorder, 0, indx);
        int[] inRight = Arrays.copyOfRange(inorder,indx+1, inorder.length );
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;


    }
}
