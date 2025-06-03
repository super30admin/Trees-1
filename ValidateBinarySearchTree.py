"""
Problem: Validate Binary Search Tree
Approach: maintain a low and high limits to determine if the current node value is within this limits set my its parents and grand
parents. When visiting a left children - update the upper limit or high with current node value and vice versa for the right children
t.c. => O(n) where n = number of nodes in the tree
s.c. => O(1) and O(n) auxiliary space for recursion stack.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root, low, high):
            if not root:
                return True
            if root.val <= low or root.val >= high:
                return False
            return helper(root.left, low, root.val) and helper(root.right, root.val, high)
        return helper(root, float("-inf"), float("inf"))
