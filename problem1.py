# Time Complexity : O(n)
# Space Complexity : O(n)   # because of the stack used for inorder traversal
# Did this code successfully run on Leetcode : Yes
# Approach:
# Perform an inorder traversal (Left → Node → Right) using a stack.
# Keep track of the previous node visited; for a valid BST, each next value must be greater.
# If any node’s value is smaller than or equal to the previous, the tree is invalid.

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []      # stack to simulate recursion for inorder traversal
        prev = None     # stores previously visited node in inorder sequence

        # Continue until there are no nodes left to process
        while stack or root:
            # Go as left as possible (like recursive inorder)
            while root:
                stack.append(root)
                root = root.left

            # Pop from stack (current node in inorder order)
            root = stack.pop()

            # In BST, inorder traversal must be strictly increasing
            if prev is not None and prev.val >= root.val:
                return False  # found a violation, not a valid BST

            # Update previous node to current before moving right
            prev = root
            root = root.right  # move to right subtree

        # If we finish traversal without violations, it's a valid BST
        return True
