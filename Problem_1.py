# Definition for a binary tree node.
import math


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root):
        self.result = True
        self.helper(root, -math.inf, math.inf)
        return self.result

    def helper(self, root, min_range, max_range):
        if not root:
            return
        if not min_range < root.val < max_range:
            self.result = False
            return
        self.helper(root.left, min_range, root.val)
        self.helper(root.right, root.val, max_range)


