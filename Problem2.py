## Problem 2

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Given preorder and inorder traversal of a tree, construct the binary tree.



# Note:
# You may assume that duplicates do not exist in the tree.

# Can you do it both iteratively and recursively?

# For example, given

# preorder = [3,9,20,15,7]


# inorder = [9,3,15,20,7]
# Return the following binary tree:

#    3


#    / \


#   9  20


#     /  \


#    15   7


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if inorder:
            root = TreeNode(preorder[0])
            pq = inorder.index(preorder.pop(0))
            root.left = self.buildTree(preorder, inorder[ : pq])
            root.right = self.buildTree(preorder, inorder[pq + 1 : ])
            return root
        
        #Time Complexity: O(h) h - height of the tree
        #Space Complexity:O(1)
        