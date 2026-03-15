#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 98: Validate Binary Search Tree
    Link: https://leetcode.com/problems/validate-binary-search-tree/

    Problem:
    Given a binary tree, determine if it is a valid binary search tree (BST).
    A BST is defined as follows:
    - The left subtree of a node contains only nodes with keys less than the node's key.
    - The right subtree of a node contains only nodes with keys greater than the node's key.
    - Both the left and right subtrees must also be binary search trees.

    Approach:
    Inorder traversal with a running prev pointer.
    In a valid BST, inorder traversal always yields a strictly increasing sequence.
    Track self.prev (initialized to -inf) and self.flag for early termination.

    1️⃣ Recurse left subtree.
    2️⃣ Check if self.prev >= current node's value → invalid, set flag = False.
    3️⃣ Update self.prev to current node's value.
    4️⃣ Recurse right subtree.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(h)
        Recursive call stack depth equals the height of the tree.

"""

import math
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = -math.inf
        def validate(root):
            if not self.flag: # This is optimization. Can be removed
                return False
            if not root:
                return True
            validate(root.left)
            if self.prev >= root.val:
                self.flag = False
            self.prev = root.val
            validate(root.right)

        validate(root)
        return self.flag
    
    
        '''
        self.prev = -math.inf
        def validate(root):

            if not root:
                return True
            left = True
            left = validate(root.left)

            if not left:
                return False
            if self.prev >= root.val:
                self.flag = False
                return False
            self.prev = root.val
            right = validate(root.right)

            return left and right

        return validate(root)

        '''
        '''
        if not root:
            return True

        def validate(root, low = -math.inf, high = math.inf):
            if not root:
                return True
            if root.val <= low or root.val >= high:
                return False

            return validate(root.left, low, root.val) and validate(root.right,
                root.val, high)
        return validate(root)
        '''
        '''
        if not root:
            return True


        def traverse(root, res):
            if root.left:
                traverse(root.left, res)
            res.append(root.val)
            if root.right:
                traverse(root.right, res)

        res = []
        traverse(root, res)

        for i in range(1, len(res)):
            if res[i-1] >= res[i]:
                return False

        return True
        '''
