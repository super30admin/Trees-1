#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Dec 16 12:14:19 2019

@author: tanvirkaur
"""

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        stack = []
        tmp = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            node = stack.pop()
            tmp.append(node.val)
            if node.right:
                root = node.right
        for i in range(len(tmp)-1):
            if tmp[i+1] <= tmp[i]:
                return False
        return True