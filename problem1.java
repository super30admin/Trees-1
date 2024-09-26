import java.util.Stack;

import javax.swing.tree.TreeNode;

// ## Problem 1

// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

class Solution {
    TreeNode prev;
    // recursive solution - T - O(n) and S - O(n)
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if(root == null)
            return true;
        if(inorder(root.left) == false) 
            return false;
        if(prev != null && root.val <= prev.val) return false;
        prev = root;
        
        return inorder(root.right);  
    }

     // iterative solution - T - O(n) and S - O(n)

    // public boolean isValidBST(TreeNode root) {
        
    //     if(root == null) return true;
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode prev = null;
        
    //     while(root != null || !stack.isEmpty()){
    //         while(root != null){
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         root = stack.pop();
            
    //         if(prev != null && root.val <= prev.val) return false;
    //         prev = root;
    //         root = root.right;

    //     }
    //     return true;
    // }
}