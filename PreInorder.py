#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Dec 16 13:42:22 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#time complexity = O(n)
#space complexity = O(1)
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder.pop(0))
        k = inorder.index(root.val)
        root.left = self.buildTree(preorder, inorder[:k])
        root.right = self.buildTree(preorder, inorder[k+1:])
        return root