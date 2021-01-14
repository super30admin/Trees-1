/**
Leetcode 98: https://leetcode.com/problems/validate-binary-search-tree/

Validate a BST

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Collabedit: http://collabedit.com/hnep6

Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Solution 
{
    
    TreeNode prev = null;
    boolean isValid = true;
    
    public boolean isValidBST(TreeNode root) 
    {
        traverseInorder(root);
        
        return isValid;
    }
    
    private void traverseInorder(TreeNode root)
    {
        if(root == null) return;
        
        if(isValid && root.left != null)
        {
            traverseInorder(root.left);
        }
        
        if(prev != null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        
        prev = root;
        
        if(root.right != null)
        {
            traverseInorder(root.right);
        }
    
    }
}