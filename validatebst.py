# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Recursively ensure each node’s value lies within its allowed low and high range.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def validate(self, root: Optional[TreeNode], low: int, high: int) -> bool:
        if not root:
            return True
        
        if root.val <= low or root.val >= high:
            return False
        
        return self.validate(root.left, low, root.val) and self.validate(root.right, root.val, high)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validate(root, -float('inf'), float('inf'))
        