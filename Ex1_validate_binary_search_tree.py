# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree (stack space); O(n) in worst case (skewed tree), O(log n) for balanced tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        #Iterative Inorder Traversal Approach

        stack = []
        prev = float("-inf")

        while stack or root:
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()

            if root.val <= prev:
                return False

            prev = root.val
            root = root.right

        return True

#-----------------------------------------------------------------------

        # Recursive Inorder Traversal
        # Time: O(n), Space: O(h)

        # def inorder(node):
        #     if not node:
        #         return True
        #     if not inorder(node.left):
        #         return False
        #     if node.val <= self.prev:
        #         return False
        #     self.prev = node.val
        #     return inorder(node.right)
        #
        # self.prev = float("-inf")
        # return inorder(root)

#-----------------------------------------------------------------------

        # Iterative Bounds Check Approach
        # Time: O(n), Space: O(n)

        # stack = [(root, float("-inf"), float("inf"))]
        # while stack:
        #     node, lower, upper = stack.pop()
        #     if not node:
        #         continue
        #     if node.val <= lower or node.val >= upper:
        #         return False
        #     stack.append((node.right, node.val, upper))
        #     stack.append((node.left, lower, node.val))
        # return True

#-----------------------------------------------------------------------

        # Recursive Bounds Check Approach
        # Time: O(n), Space: O(h)

        # def valid(node, left, right):
        #     if not node:
        #         return True
        #     if not (left < node.val < right):
        #         return False
        #     return valid(node.left, left, node.val) and valid(node.right, node.val, right)
        #
        # return valid(root, float("-inf"), float("inf"))
