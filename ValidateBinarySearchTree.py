# Time Complexity : O(n)
# Space Complexity : O(n)

from typing import List

#Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def isValid(node, min_val, max_val):
            if not node:
                return True
            if node.val <= min_val or node.val >= max_val:
                return False
            return isValid(node.left, min_val, node.val) and isValid(node.right, node.val, max_val)
        
        return isValid(root, float('-inf'), float('inf'))