#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
    Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    Problem:
    Given two integer arrays preorder and inorder where preorder is the preorder
    traversal of a binary tree and inorder is the inorder traversal of the same tree,
    construct and return the binary tree.

    Note: You may assume that duplicates do not exist in the tree.

    Approach:
    Use a hashmap for O(1) inorder index lookup and a global index pointer into preorder.
    The first element of preorder is always the root. Its position in inorder splits
    the tree into left and right subtrees.

    1️⃣ Build inorderMap: value → index for O(1) lookup.
    2️⃣ self.idx tracks the current root in preorder (starts at 0).
    3️⃣ createTree(left, right) defines the valid inorder window.
    4️⃣ Pick preorder[self.idx] as root, increment self.idx.
    5️⃣ Recurse left on inorder[left : nodeIdx-1], then right on inorder[nodeIdx+1 : right].

    // Time Complexity : O(n)
        Each node is visited once; hashmap gives O(1) index lookup.
    // Space Complexity : O(n)
        O(n) for the hashmap + O(h) recursive call stack (h = height of tree).

"""

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.inorderMap = {val: idx for idx, val in enumerate(inorder)}  # Map value to index for O(1) lookup
        self.idx = 0
        return self.createTree(preorder, 0, len(inorder) - 1)

    def createTree(self, preOrder, left, right):
        if left > right:
            return None

        nodeValue = preOrder[self.idx]
        self.idx += 1

        nodeIdx = self.inorderMap[nodeValue]

        node = TreeNode(nodeValue)

        node.left = self.createTree(preOrder, left, nodeIdx - 1)
        node.right = self.createTree(preOrder, nodeIdx + 1, right)

        return node

    '''
    def createTree(self, preorder: List[int], inorder: List[int], inorderMap: dict) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None  # Base case: stop recursion if preorder or inorder list is empty

        root_val = preorder[0]
        root = TreeNode(root_val)  # Create the root node with the first value in preorder

        indexroot = -1
        for item in inorder:
            indexroot += 1
            if item == root_val:
                break

        leftin = inorder[:indexroot]
        rightin = inorder[indexroot + 1:]

        leftpre = preorder[1: len(leftin) + 1]
        rightpre = preorder[len(leftin) + 1:]

        root.left = self.createTree(leftpre, leftin, inorderMap) if leftin else None
        root.right = self.createTree(rightpre, rightin, inorderMap) if rightin else None

        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorderMap = {val: idx for idx, val in enumerate(inorder)}  # Map value to index for O(1) lookup
        return self.createTree(preorder, inorder, inorderMap)
    '''

    '''
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None

        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root
    '''
