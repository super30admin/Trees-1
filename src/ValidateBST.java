// Time Complexity : O(n), n = number of nodes in the tree
// Space Complexity : O(h), h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/**
 * every time we go one level down in the tree in left and right side, max and min allowed values range changes
 * if current node crosses or touches this limit, then BST is not valid
 * 
 */

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

approach 2: keep track of previously popped node from stack, if that node is larger than current node, then BST test fails.

for left subtree, prev is child of current element, for right subtree prev is parent of current node, so prev >= current condition
works for both sides. intution : from the iterative inorder traversal and its stack movement
 *
 */

import java.util.Stack;

public class ValidateBST {
	
	TreeNode prev;
	
	 public boolean isValidBST(TreeNode root) {
	        
	        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
	    //recursive solution using range check
	    private boolean isValidBST(TreeNode root, long min, long max) {
	        //base
	        if(root == null) return true;
	        
	        //logic
	        if(root.val <= min || root.val >= max) return false;
	        
	        else return (isValidBST(root.left, min, root.val) &&
	                       isValidBST(root.right, root.val,max));
	        
	    }
	    
	    
	    //iterative solution using prev poped node, (using global previous node so it will not be lost when 
	    // recursion unwinds
	    private boolean isValidBSTIterative(TreeNode root) {
	        //base
	        Stack<TreeNode> st = new Stack<>();
	        
	         while(root != null || !st.isEmpty()) {
	            while(root != null) {
	                st.push(root);
	                root = root.left;
	            }
	            
	            root = st.pop();
	            if(prev!= null && prev.val >= root.val) return false;
	             
	            prev = root;
	             
	            root = root.right;
	        }
	        
	        return true;
	    }
}
