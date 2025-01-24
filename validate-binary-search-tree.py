"""

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false

Time Complexity:
- Method 1 (Recursive): O(N), where N is the number of nodes (each node is visited once).
- Method 2 (Iterative): O(N), as it performs an in-order traversal.

Space Complexity:
- Method 1 (Recursive): O(N) in the worst case (skewed tree) due to recursive call stack.
- Method 2 (Iterative): O(N) in the worst case (skewed tree), but O(log N) for balanced trees.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# 1. The first method uses a recursive approach with a range check for each node, ensuring it falls within valid BST constraints.
# 2. The second method performs an in-order traversal using an iterative approach with a stack, verifying that the values are in strictly increasing order.
# 3. Both approaches validate the BST property, but the second approach leverages an iterative traversal for better space efficiency in balanced trees.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        # method 1: Recursive approach with range validation
        def isValid(node, left, right):
            if not node:
                return True
            if not (left < node.val < right):
                return False
            return (isValid(node.left, left, node.val) and 
                    isValid(node.right, node.val, right))

        return isValid(root, float("-inf"), float("inf"))

        # method 2: Iterative in-order traversal
        if root is None:
            return True

        stack = []
        prev = None

        while root is not None or len(stack) > 0:
            while root is not None:
                stack.append(root)
                root = root.left

            root = stack.pop()

            if prev is not None and prev.val >= root.val:
                return False

            prev = root
            root = root.right

        return True
