# One-line summary: Recursively validate each subtree by carrying down (min, max) bounds that every node must lie within.
# Time Complexity: O(n) — each node is visited exactly once.
# Space Complexity: O(h) — recursion stack uses O(h) where h is tree height (O(n) worst-case, O(log n) for balanced trees).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def helper(self, node, low=float('-inf'), high=float('inf')):
        """
        Recursive helper that validates the subtree rooted at `node`.

        Args:
            node: current TreeNode (or None).
            low: lower exclusive bound for node.val (all values in this subtree must be > low).
            high: upper exclusive bound for node.val (all values in this subtree must be < high).

        Returns:
            True if the subtree is a valid BST under the given bounds, False otherwise.

        Key idea:
            - For a valid BST, every node's value must be strictly between the bounds passed down from its ancestors.
            - When going left, the current node value becomes the new upper bound (high) because all left-subtree
              values must be less than the current node.
            - When going right, the current node value becomes the new lower bound (low) because all right-subtree
              values must be greater than the current node.
            - Using exclusive bounds (< and >) enforces the strictness required by BST definition.
        """
        # An empty subtree is valid.
        if not node:
            return True

        # If current node violates the allowable range, it's not a BST.
        # Note: we use strict inequalities: low < node.val < high
        if not (low < node.val < high):
            return False

        # Recursively validate left and right subtrees with updated bounds:
        # - left subtree: values must be > low and < node.val
        # - right subtree: values must be > node.val and < high
        # If either subtree is invalid, the whole tree is invalid.
        return (self.helper(node.left, low, node.val) and
                self.helper(node.right, node.val, high))
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        """
        Entry point: start with the widest possible bounds (-inf, +inf).
        """
        return self.helper(root)
