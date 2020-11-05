package Nov4;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        
/* 
	Time Complexity: O(n) where n is number of nodes in the given tree.
	Because we will iterate through each of the tree nodes once.

	Space Complexity: O(h) where h is height of the tree.
	Because recursive stack will have at max all leftward children of root node at a time when we start popping from the stack.
    If it is a skewed tree and all nodes of binary tree are towards left, then space complexity will be O(n).
	      
	Did this code successfully run on Leetcode : Yes

	Any problem you faced while coding this : No

	Approach:
    Inorder traversal of the tree done using a stack in an iterative manner.
    We are storing last processed node of inorder traversal in prev and comparing current node with prev everytime. 
    If prev value > current root value, then the given tree is an invalid BST.
 
*/

// prev pointer moves one step behind current root pointer in the logic below
        TreeNode prev = null;

// Stack to mimic the recursive stack created for which we will handle the logic using our own code.
        Stack<TreeNode> st = new Stack<>();
        
        // CORE LOGIC
        while (root != null || !st.isEmpty()) {
        
// push all nodes from root till you reach leaf node such that at each node, traversal is done on left child  
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            
// prev node should ideally be < root node value for a valid BST because we are iterating inorder, and prev is one step behind current node, so it will ideally be less than root node val for the given tree to be a valid BST.If not, we can return false from here itself.
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            
            prev = root;
            root = root.right;
            
        }
        
        return true;
      
    }
}
