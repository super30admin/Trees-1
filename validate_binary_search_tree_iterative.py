"""
Problem: Validate Binary Search Tree
Leetcode: https://leetcode.com/problems/validate-binary-search-tree/
Solution: Iterative approach
Time Complexity: O(N), since we visit each node
Space Complexity: O(N), since we store entire tree
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def isValidBST(self, root) -> bool:
        if not root:
            return True

        stack = [(root, float('-inf'), float('inf'))]
        while stack:
            root, lower, upper = stack.pop()
            if not root:
                continue
            value = root.val

            if value <= lower or value >= upper:
                return False

            stack.append((root.left, lower, value))
            stack.append((root.right, value, upper))

        return True