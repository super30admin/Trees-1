#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Dec 16 12:12:31 2019

@author: tanvirkaur
"""
# leetcode Acceptance = Yes
# Time complexity = O(n)
# Space complexity = O(1) if we donot consider the recursion stack
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.minmax(root, float('-inf'), float('inf'))
    
    def minmax(self, root, minn, maxx):
        # base case
        if not root:
            return True
        if minn!= None and root.val <= minn:
            return False
        if maxx!= None and root.val >= maxx:
            return False
        # logic
        left= self.minmax(root.left, minn, root.val) 
        right = self.minmax(root.right, root.val, maxx)
        return left and right
