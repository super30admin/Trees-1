/**
 * 
 */
package BinaryTree_LC105;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author neha
 *
 */


public class BinaryTree_LC105 {

	/**
	 * @param args
	 */
	
public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode(int x) 
	     { 
	    	 val = x; 
	    	 }
	     
	 }
	static TreeNode root; 
	
	HashMap<Integer, Integer> map = new HashMap<>();
    int index = 0;

public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Edge case if inorder length is 0
    
    if(inorder.length == 0)
    {
        return null;
    }
    
    for(int i=0;i<inorder.length;i++)
    {
        map.put(inorder[i],i);
    }
    return helper(preorder,inorder);
    
}

private TreeNode helper(int[] preorder, int[] inorder)
{
    if(preorder.length ==0 || inorder.length ==0)
    {
        return null;
    }
    
    index = map.get(preorder[0]);
    TreeNode root = new TreeNode(preorder[0]);
    int[] inLeft = Arrays.copyOfRange(inorder,0,index);
    int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
    int[] preLeft =  Arrays.copyOfRange(preorder,1,index+1);
int[] preRight =  Arrays.copyOfRange(preorder,index+1,preorder.length);
    root.left = buildTree(preLeft,inLeft);
    root.right = buildTree(preRight,inRight);
    return root;
}

void printInorder(TreeNode node) 
{ 
    if (node == null) 
        return; 

    /* first recur on left child */
    printInorder(node.left); 

    /* then print the data of node */
    System.out.print(node.val + " "); 

    /* now recur on right child */
    printInorder(node.right); 
} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree_LC105 Tree = new BinaryTree_LC105();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode Binary_tree = Tree.buildTree(preorder,inorder);
		System.out.println("The Inorder Tree Traversal is");
		Tree.printInorder(Binary_tree);

	}

}
