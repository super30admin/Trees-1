/*
 * #105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
 */


/*
 * Time Complexity: O (N*N) -> O (N^2) // N - Traverse all nodes of a tree while constructing tree
 * 									   // N - For each node, traverse through N or N-1 or N-2 etc elements in a inorder array to find root for every recursive call
 * 
 * Space Complexity: O (N) + O (N*M) -> O (N*M) // N - Recursive stack space to store 'N' nodes of a tree
 * 							 		// (N*M) - total space for creating copy of arrays for each node of a tree in every recursive call
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees1;

import java.util.Arrays;


//Definition for a binary tree node.
class NodeTree {
	int val;
	NodeTree left;
	NodeTree right;
	NodeTree() {}
	NodeTree(int val) { this.val = val; }
	NodeTree(int val, NodeTree left, NodeTree right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class ConstructBTInPre {
	public NodeTree buildTree(int[] preorder, int[] inorder) {
        
		// Base condition
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        // Find the root element from preorder array for every recursive call
        // Initially, we know the root is first element in preorder array
        NodeTree root = new NodeTree(preorder[0]);
        
        int index = -1; // Initialize the index
        
        // Find the index of root element in inorder array for every recursive call
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        // Find the left subtree size in inorder array for every recursive call
        int leftSize = index - 0;
        
        // Create the 4 arrays as a copy of respective original array for every recursive call
        // inorder left, inorder right, preorder left and preorder right 
        
        // e.g: inLeft = (inorder, 0, 1(leftSize)) -> 1 is exclusive, last index is exclusive
        // We are dividing the given problems into smaller subproblems
        int[] inLeft = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, leftSize+1);
        
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] preRight = Arrays.copyOfRange(preorder, leftSize+1, preorder.length);
        
        // Now, apply the recursion on both left and right arrays (for inorder and preorder both) to build a tree
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        // return root (whole binary tree)
        return root;
        
    }

}
