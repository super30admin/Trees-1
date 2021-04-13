# -*- coding: utf-8 -*-
"""
Created on Mon Apr 12 18:22:16 2021

@author: jgdch
"""

#Time Complexity:O(N), N is the numbe rof ndoes in the tree
#Space Complexity:O(H), H is the height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def isValid(node, low=float("-inf"), high=float("inf")):
            if not node:
                return True
            if node.val <= low or node.val >= high:
                return False

            return (isValid(node.right, node.val, high) and
                   isValid(node.left, low, node.val))

        return isValid(root)        