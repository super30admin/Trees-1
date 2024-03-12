# https://leetcode.com/problems/validate-binary-search-tree/

# Time Complexity : O(N) is Number of nodes in the tree.
# Space Complexity : O(H) where H is height of the tree, and stack space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach.
# Approach - We have min and max value at every node, and we have to compare it with the node value.
# If we go left, we just update the max value with root. If we go right we update the min with root val.

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    valid = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.valid = True
        self.inorder(root, float("-inf"), float("inf"))
        return self.valid

    def inorder(self, root, minVal, maxVal):
        if root is None or self.valid is False:
            return

        self.inorder(root.left, minVal, root.val)

        if root.val <= minVal or root.val >= maxVal:
            self.valid = False

        self.inorder(root.right, root.val, maxVal)
