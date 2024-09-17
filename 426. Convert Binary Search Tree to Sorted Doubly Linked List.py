"""
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
"""
"""

"""


class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def helper(node):
            ###inorder traversal-> low to high asc ord
            """
            left, root(processing), right
            """
            ##base case
            nonlocal first
            nonlocal last
            if node:
                helper(node.left)
                if last:
                    last.right = node
                    node.left = last
                else:
                    first = node
                last = node
                helper(node.right)

        if not root:
            return None
        first = None
        last = None
        helper(root)
        last.right = first
        first.left = last
        return first

