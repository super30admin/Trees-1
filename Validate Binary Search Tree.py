# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
TC: O(n)
SC: O(n)
"""
class Solution:
    def isValidBST(self, node, min_value = -math.inf , max_value = math.inf ) -> bool:
        if not node:
            return True

        if node.val >= max_value or node.val <= min_value:
            return False

        return self.isValidBST(node.left, min_value,node.val) and self.isValidBST(node.right, node.val,max_value)
