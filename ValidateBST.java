package com.ds.rani.tree;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees. Example 1:
 * <p>
 * 2
 * / \
 * 1 3
 * <p>
 * Input: [2,1,3] Output: true
 * <p>
 * Example 2:
 * 5
 * / \
 * 1 4
 * / \
 * 3   6
 * Input: [5,1,4,null,null,3,6] Output: false Explanation: The root node's value is 5 but its right child's value is 4.
 */

//Approach:I have used Inorder traversal approach to check whether the value poped from stack is less than the current node or not
// If popped values is greter than current node it means left or root node is greater than current node so it cannot be BST

//Time Complexity:o(n)
//Space Complexity:o(n) where n is number of nodes in a tree( In worst case if all the nodes are less than or greter than root then stack will consists of all the nodes)

public class ValidateBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;
        //Using Inorder traversal approach
        while (!stack.isEmpty() || curr != null) {
            //traverse to the left side and add all the nodes in stack
            if (curr != null) {
                stack.push( curr );
                curr = curr.left;
            } else {// whenever left node is null then pop one node from the stack(which is root of that node)
                curr = stack.pop();
                if (prev != null && prev.val >= curr.val) return false;
                prev = curr;
                curr = curr.right;
            }
        }
        return true;
    }
}
