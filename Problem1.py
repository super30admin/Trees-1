"""
Implemented with reference to the homework solution.
Time Complexity: O(n)
Space Complexity: O(h)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(node, minVal, maxVal):
            if not node:
                return True
            if (minVal is not None and node.val <= minVal) or (maxVal is not None and node.val >= maxVal):
                return False
            return helper(node.left, minVal, node.val) and helper(node.right, node.val, maxVal)
        
        return helper(root, None, None)
        