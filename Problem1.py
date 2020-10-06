# Time Complexity: O(N)
# Space Complexity: O(log(N))
# Passed Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recurse(self, node, min_val, max_val):
        
        if node:
            
            if node.val <= min_val or node.val >= max_val:
                return False
            
            valid_left = self.recurse(node.left, min_val, node.val)
            
            valid_right = self.recurse(node.right, node.val, max_val)
                
            if not valid_left or not valid_right:
                return False
        return True
            
        
        
    
    def isValidBST(self, root: TreeNode) -> bool:
        
        
        return self.recurse(root, -float("inf"), float("inf"))