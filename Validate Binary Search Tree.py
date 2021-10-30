# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(n)
# Logic: do an inorder traversal & after hitting null in a leaf node. the stack will contain all the left elements,
# the previous should be always less than current node, even when going right of node. parent has to smaller than right
# node i.e. prev should always be smaller than current node.

# Definition for a binary tree node.
import math


class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root):
        stack = []
        prev = -math.inf
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= prev:
                return False
            prev = root.val
            root = root.right
        return True
