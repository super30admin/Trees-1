## Problem 1

        https://leetcode.com/problems/validate-binary-search-tree/

        Given a binary tree, determine if it is a valid binary search tree (BST).

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

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        return valid(root,null,null);
    }


    public boolean valid(TreeNode root,Integer max,Integer min){

        if(root==null){
            return true;
        }
        if(min!=null && root.val<=min || max!=null && root.val>=max){
            return false;
        }
        else {

            return valid(root.left,root.val,min) && valid(root.right,max,root.val);
        }
    }
}