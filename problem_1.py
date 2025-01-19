"""
Problem 1: Validate Binary Search Tree (https://leetcode.com/problems/validate-binary-search-tree/)
TC: O(N)
SC: O(N)
Approach: Inorder traversal of BST gives sorted array. If the array is sorted then it is a valid BST.
"""


from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        self.values = []
        self.inorder(root)
        for i in range(1, len(self.values)):
            if self.values[i] <= self.values[i - 1]:
                return False
        return True

    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        self.values.append(root.val)
        self.inorder(root.right)