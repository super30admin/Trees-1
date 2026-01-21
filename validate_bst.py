# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, float("-inf"), float("inf"))

    def helper(self, root, low, high):
        if not root:
            return True

        if root.val <= low or root.val >= high:
            return False

        return self.helper(root.right, root.val, high) and self.helper(
            root.left, low, root.val
        )
