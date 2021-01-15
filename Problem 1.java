// ITERATIVE SOLUTION
//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(h) where h is the height of the tree
//Sucessfully runs on leetcode: 1 ms
//Approach: Here we do inorder traversal of the tree in an iterative manner by creating our own stack - we maintain two
//pointers (prev and root) to compare if the inorder traversal is not breaching the increasing order of the tree node values.
//We traverse till the leftmost node, then consider root value and traverse till the rightmost node to check if its valid BST.
//The prev pointer makes sure that left child < root < right child.

/**
 * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
import java.util.*;
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}


//RECURSIVE APPROACH
//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(h) where h is the height of the tree if we consider recursive stack space
//Sucessfully runs on leetcode: 0 ms

//Approach: We take a global variable prev that keeps a track of previous nodes in the inorder traversal. We
//reach the leftmost node recursively and compare its value with root and similarly, we do recursion on right subtree
//and compare the root with prev. At any point of time, if prev >= root, we return false.

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
class Solution {
    public boolean isValid;
    public TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        isValid = true;
        helper(root);
        return isValid;
    }
    
    private void helper(TreeNode root)
    {
        //base
        if(root == null) return;
        //logic
        helper(root.left);
        if(prev != null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        prev = root;
        helper(root.right);
    }
}


//ANOTHER VERSION FOR RECURSIVE APPROACH

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
class Solution {
    //public boolean isValid;
    public TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //isValid = true;
        return helper(root);
        //return isValid;
    }
    
    private boolean helper(TreeNode root)
    {
        //base
        if(root == null) return true;
        //logic
        if(helper(root.left) == false) return false;
        if(prev != null && prev.val >= root.val)
        {
            //isValid = false;
            return false;
        }
        prev = root;
        return helper(root.right);
    }
}