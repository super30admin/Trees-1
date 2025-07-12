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

Approach:- 
1. We know a property of BST that the left child of the BST is always less than the root value and the right child of the BST is always greater     than   the root value
2. If any of the above condition fail then we can return false

TC: O(n)
sc: O(H)

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE); 
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) { //The root value must always be greater than the min value and the root value must always be less than the max value
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
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

1. We know that the prorder traversal is where Root always comes first and hence we can find the root from the preorder array
2. We will built the left and right subtree using the inorder array
3. We will find the index at which our root is present in the inorder array as we know that in inorder traversal we will first traverse the left side and then the root and the right 
4. So the index at which we will find the root value in inorder array the left subtree will be from 0 to i-1 index and the right subtree will be from i+1 to inorder.length-1 where i = the index at which we find the root in inorder array

TC: O(n); 
Sc = O(H)

public class Solution {
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        TreeNode root = recurse(preorder, inorder, 0, inorder.length - 1);

        return root;
    }

    public TreeNode recurse(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx]);

        int i = start;

        while(inorder[i] != preorder[preIdx]){
            i++;
        }

        preIdx++;

        root.left = recurse(preorder, inorder, start, i-1);

        root.right = recurse(preorder, inorder, i+1, end);

        return root;
    }
}