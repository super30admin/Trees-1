# Trees-1

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


class Solution {
    private boolean isBSTHelper(TreeNode node, long lower_limit, long upper_limit) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower_limit || upper_limit <= node.val) {
            return false;
        }
        return isBSTHelper(node.left, lower_limit, node.val) && isBSTHelper(node.right, node.val, upper_limit);
    }
    public boolean isValidBST(TreeNode root) {
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

class Solution {
    TreeNode prev;
    private boolean inOrder(TreeNode root){
        if (root == null)
            return true;
        
        boolean left = inOrder(root.left);
        if (left == false)
            return false;

        if(prev != null && prev.val >= root.val)
            return false;
        
        prev = root;
        boolean right;
        if (left){
            right = inOrder(root.right);
        } else {
            return false;
        }
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
}


class Solution {
    boolean flag;
    private boolean helper(TreeNode root, long min, long max){
        if (root==null)
            return true;
        
        if ( root.val<= min || root.val >= max)
            return false;

        boolean left =  helper(root.left, min, root.val);

        boolean right;
        if (left)
            right = helper(root.right, root.val, max);
        else
            return false;

        return right && left;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

## Problem 2

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7


