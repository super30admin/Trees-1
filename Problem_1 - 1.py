"""
Iterative Solution 
Time Complexity : O(n)
Space Complexity : O(h)
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        prev = None
        stack = []
        
        while root or stack:
            
            while root:
                stack.append(root)
                root = root.left 
                
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                return False 
            prev = root
            root = root.right 
        
        return True 
        
         
            