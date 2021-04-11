# Trees-1

## Problem 1

# https://leetcode.com/problems/validate-binary-search-tree/

# Given a binary tree, determine if it is a valid binary search tree (BST).

# Assume a BST is defined as follows:

# The left subtree of a node contains only nodes with keys less than the node's key.
# The right subtree of a node contains only nodes with keys greater than the node's key.
# Both the left and right subtrees must also be binary search trees.
# Example 1:

#    2

#    / \

#   1   3

# Input: [2,1,3]
# Output: true
# Example 2:

#    5

#    / \

#   1   4

#      / \

#     3   6

# Input: [5,1,4,null,null,3,6]
# Output: false
# Explanation: The root node's value is 5 but its right child's value is 4.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def validate(node, low=-math.inf, high=math.inf):
            if node== None:
                return True
            if node.val <= low or node.val >= high:
                return False
            return (validate(node.right, node.val, high) and
                   validate(node.left, low, node.val))

        return validate(root)
     #Time Complexity: O(n)
    #Space Complexity: O(n)
        