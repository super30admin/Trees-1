package binaryTrees;

import java.util.Arrays;
/**
 * Approach: Split left subtree elements and right subtree elements and repeatedly perform the buidtree function
 * 
 */
public class BinaryTreeFromPreorderInorder {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        
        //First Element in preorder traversal is always root
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        
        //Find the index of root from inorder
        for(int i=0; i<inorder.length; i++) {
        		if(inorder[i] == root.val) {
        			index = i;
        		}
        }
        
        //Split preorder traversal of left subtree and right subtree
        int[] preleft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preright = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        //Split inorder traversal of left subtree and right subtree
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        //Append the root-left and root-right with corresponding nodes
        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        return root;
    }
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		buildTree(preorder, inorder);
	}

}
