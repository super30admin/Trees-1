# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity :
# O(N) since we visit each node exactly once.
# Space complexity :
# O(N) since we keep up to the entire tree.
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.helper(root, float('inf'), float('-inf'))

    def helper(self, root, currMax, currMin):
        # base Case
        if not root:
            return True
        if root.val <= currMin or root.val >= currMax:
            return False
        # Logic
        return self.helper(root.left, root.val, currMin) and self.helper(root.right, currMax, root.val)

