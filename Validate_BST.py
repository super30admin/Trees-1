# TC and SC - O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValid(self, root, left_bound, right_bound):
        if root is None:
            return True
        
        if not(left_bound < root.val and root.val < right_bound):
            return False
        
        return self.isValid(root.left, left_bound, root.val) and self.isValid(root.right, root.val, right_bound)
        
    def isValidBST(self, root):
        if root is None: return True
        return self.isValid(root, float('-inf'), float('inf'))   