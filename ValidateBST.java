/*
 * #98. Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]

Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]

Output: false

Explanation: The root node's value is 5 but its right child's value is 4.

 */


/*
 * Time Complexity: O (N) -> where 'N' is number of nodes in a tree
 * 
 * Space Complexity: O (N) -> Created stack to store 'N' nodes of a tree 
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */
package com.s30.edu.trees1;

import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }

// Iterative Approach
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
        // Base condition
        // If root is null, then valid BST, so return true
        if(root == null){
            return true;
        }
        
        // Create a stack to push and pop tree nodes
        Stack<TreeNode> stack = new Stack<>();
        // Initialize the previous and current pointers
        // Initially, prev and curr both will be null
        TreeNode prev = null;
        TreeNode curr = null;
        
        /*
        * We are using Inorder Traversal to validate given tree is a BST or not.
        * Inorder Traversal gives the tree nodes in sorted order
        * While traversing the tree itself, we can keep track of previous and current node 
        * and compare them to check if tree satisfies the properties of BST
        * Inorder Traversal -> left-root-right
        */
        
        // Keep traversing the tree until stack is empty or root(current node) is null
        while(!stack.isEmpty() || root != null){
            while(root != null){ // traverse to the leftmost node in left subtree
                stack.add(root); // keep adding all the nodes in stack
                root = root.left; // After adding node in stack, go to the left of root(current) node
            }
            
            // pop top node in stack as a current node
            curr = stack.pop(); 
            
            // Now check if previous node is not null and its value is not grater than or equal to current node
            // If yes, then it is not BST, return false
            // Else, it is a valid BST
            if(prev != null && prev.val >= curr.val){
                return false;
            }
            
            // Before traversing the right subtree of a current node, assign the current node to previous node
            prev = curr;
            
            // Go to the right subtree/node of a current node
            root = curr.right;
                
            
        }
        
        return true; // return true if given tree is a valid BST
   
    }

}
