'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    preIndex = 0
    nodeMap = {}
    
    def helper(self, preorder: list[int], start: int, end: int) -> Optional[TreeNode]:
        if end < start:
            return None
        idx = self.nodeMap[preorder[self.preIndex]]
        root = TreeNode(preorder[self.preIndex])
        self.preIndex += 1
        root.left = self.helper(preorder, start, idx - 1)
        root.right = self.helper(preorder, idx + 1, end)
        return root
        
    def buildTree(self, preorder: list[int], inorder: list[int]) -> Optional[TreeNode]:
        # null
        if len(preorder) == 0:
            return None
        for index in range(len(inorder)):
            self.nodeMap[inorder[index]] = index
        return self.helper(preorder, 0, len(inorder) - 1)