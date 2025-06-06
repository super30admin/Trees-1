''' 
Problem: Validate Binary Search Tree
Leetcode Link: https://leetcode.com/problems/validate-binary-search-tree/description/ 

Approach: 
- A binary search tree (BST) is a binary tree in which every node follows the properties:
# 1. The left subtree of a node contains only nodes with keys less than the node's key.
# 2. The right subtree of a node contains only nodes with keys greater than the node's key. 

- We use recursion to validate the BST by checking if each node's value is within a valid range.
- For every left iteration, we update the upper bound to the current node's value.
# For every right iteration, we update the lower bound to the current node's value.

Time Complexity: O(N) as we traverse each node once.
Space Complexity: O(H) where H is the height of the tree, due to recursion stack, 
                  O(1) if we ignore the recursion stack space
                  O(N) if we consider the space used by the recursion stack in the worst case (skewed tree).
'''

# Initial Attempt 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, minValue, maxValue):
            if node is not None:
                if node.val > minValue and node.val < maxValue:
                    return validate(
                        node.left,
                        min(minValue, node.val),
                        node.val,
                    ) and validate(node.right, node.val, maxValue)
                elif node.val > minValue and node.val < maxValue:
                    return validate(
                        node.right, node.val, max(node.val, maxValue)
                    ) and validate(node.left, minValue, node.val)
                else:
                    return False
            else:
                return True

        if root is not None:
            return validate(root.left, float("-inf"), root.val) and validate(
                root.right, root.val, float("inf")
            )
        return False


# Optimized Code with concise logic 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def check(node, minValue, maxValue):
            if not node:
                return True

            if not (minValue < node.val < maxValue):
                return False

            return check(node.left, minValue, node.val) and check(
                node.right, node.val, maxValue
            )

        return check(root, float("-inf"), float("inf"))