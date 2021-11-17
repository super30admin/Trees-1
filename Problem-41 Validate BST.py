# 98. Validate Binary Search Tree
# https://leetcode.com/problems/validate-binary-search-tree/

# Time complexiety: O(n)
# Space complexiety: O(1)

# Logic: Check if the left node is less than the parent node and right node is more than the parent node
# use min and max values to see if the current node is between them it is correct
# left value has to be between -inf and root
# right value has to be between root and inf

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def _helper(self,node,min_val,max_val):
        if not node:
            return True
        
        if node.val >= max_val or node.val <= min_val:
            return False
        
        left = self._helper(node.left,min_val,node.val)
        right = self._helper(node.right,node.val,max_val)
        
        return left and right
    
    def isValidBST(self, root) -> bool:
        ptr = root
        return self._helper(ptr,float("-inf"),float("inf"))