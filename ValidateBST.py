# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, left, right):
            if not node:
                return True
            if not (node.val < right and node.val > left):
                return False
            return (validate(node.left, left, node.val) and
                    validate(node.right, node.val, right))
        return validate(root, float("-inf"), float("inf"))