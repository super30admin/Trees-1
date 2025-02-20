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



class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def valid(node,left,right):
            if not node:
                return True
            if not (node.val > left and node.val < right):
                return False
            
            return (valid(node.left,left,node.val)and 
                    valid(node.right,node.val,right))
        return valid(root,float(-inf),float(inf))

        

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
