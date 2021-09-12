#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 11 23:35:28 2021

@author: ameeshas11
"""

#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    hashm = {}
    
    def get_nodes(self,pre, ino, pre_point, l, h):
        root = TreeNode(pre[pre_point])
        i = Solution.hashm[root.val]
        if i==l:
            root.left = None
        else:
            root.left = self.get_nodes(pre, ino, pre_point+1, l, i-1)
        if i==h:
            root.right = None
        else:
            root.right = self.get_nodes(pre, ino, pre_point+1+i-l, i+1, h)
        
        return root
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if len(preorder) == 1:
            return TreeNode(preorder[0])
        
        for i in range(len(inorder)):
            Solution.hashm[inorder[i]] = i
        return self.get_nodes(preorder, inorder, 0, 0, len(inorder)-1)
        
        return root
        