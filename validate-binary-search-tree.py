#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep  7 15:13:14 2021

@author: ameeshas11
"""

#Time Complexity : O(n)
#Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = deque()
        out = []
        while root!=None or len(stack)!=0:
            while root!=None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if len(out) > 0:
                if root.val <= out[-1]:
                    return False
            out.append(root.val)
            root = root.right
            
        return True