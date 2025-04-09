# Approach: Top-Down Recursion with min/max bounds
# At each node, check if its value is within the valid range (min < node < max)
# Recursively validate left and right subtrees with updated bounds
# TC = O(n) — each node is visited once
# SC = O(h) — call stack for recursion (h = height of tree)
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class SolutionBounds:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, minVal, maxVal):
        if root is None:
            return True

        if minVal is not None and root.val <= minVal:
            return False
        if maxVal is not None and root.val >= maxVal:
            return False

        return self.helper(root.left, minVal, root.val) and self.helper(
            root.right, root.val, maxVal
        )


# Approach: Iterative In-order Traversal
# A BST's in-order traversal yields values in strictly increasing order
# Use a stack to simulate recursion and compare each node with the previous one
# TC = O(n) — each node is visited once
# SC = O(n) - worst case (skewed tree)
class SolutionIterative:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = None

        while root is not None or stack:
            while root is not None:
                stack.append(root)
                root = root.left

            root = stack.pop()

            if prev is not None and root.val <= prev.val:
                return False

            prev = root
            root = root.right

        return True


# Approach:Recursive In-order Traversal with prev pointer
# In-order traversal must yield strictly increasing values for a BST
# TC = O(n) — each node is visited once
# SC = O(h) — call stack for recursion (h = height of tree)
class SolutionRecursiveInorder:
    def __init__(self):
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root)

    def helper(self, root):
        if root is None:
            return True

        if not self.helper(root.left):
            return False

        if self.prev is not None and root.val <= self.prev.val:
            return False

        self.prev = root
        return self.helper(root.right)


# Tree:
#      5
#     / \
#    3   7
#   / \   \
#  2   4   8
# =======================
def build_sample_tree():
    root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(7)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(8)
    return root


if __name__ == "__main__":
    root = build_sample_tree()
    print("Using min/max bounds:", SolutionBounds().isValidBST(root))
    print("Using iterative in-order:", SolutionIterative().isValidBST(root))
    print("Using recursive in-order:", SolutionRecursiveInorder().isValidBST(root))
